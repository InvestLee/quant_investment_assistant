package jhlee.api.http;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import jhlee.api.common.error.CustomErrorCode;
import jhlee.api.common.error.RetrofitErrorCode;
import jhlee.api.common.exception.ApiException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

import java.io.IOException;
import java.util.Map;

@Component
public class HttpClient {
    private static final Logger log = LoggerFactory.getLogger(HttpClient.class);
    private final Gson gson = new Gson();
    private int attempt = 0;

    @Retryable(value = IOException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public Map<String, Object> sendPostRequest(String baseUrl, String endpoint, Map<String, Object> params) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String jsonParams = gson.toJson(params);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, jsonParams);

        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.sendPostRequest(endpoint, body);

        return executeCall(call);
    }

    public Map<String, Object> executeCall(Call<ResponseBody> call) throws IOException {
        attempt++;
        log.info("재시도 횟수: {}", attempt);

        try {
            Response<ResponseBody> response = call.execute();
            if (response.isSuccessful()) {
                return handleResponseBody(response.body());
            } else {
                return handleErrorResponse(response);
            }
        } catch (IOException e) {
            log.error("[ERROR] 네트워크 요청 실패: {}", e.getMessage());
            throw e;
        }
    }

    private Map<String, Object> handleResponseBody(ResponseBody responseBody) throws IOException {
        try (responseBody) {  // ResponseBody를 안전하게 처리하기 위해 try-with-resources 사용
            String responseBodyString = responseBody.string();
            return gson.fromJson(responseBodyString, new TypeToken<Map<String, Object>>() {}.getType());
        }
    }

    private Map<String, Object> handleErrorResponse(Response<ResponseBody> response) throws IOException {
        String errorBody = response.errorBody() != null ? response.errorBody().string() : "";
        Map<String, Object> errorResponse = errorBody.isEmpty() ?
                Map.of("message", "Unknown error") :
                gson.fromJson(errorBody, new TypeToken<Map<String, Object>>() {}.getType());

        throw new ApiException(
                new CustomErrorCode(
                        response.code(),
                        response.code(),
                        "외부 API 에러"),
                (String) errorResponse.getOrDefault("message", "Unknown error")
        );
    }

    @Recover
    public Map<String, Object> recover(
            IOException e,
            String baseUrl,
            String endpoint,
            Map<String, Object> params
    ) {
        log.error("최대 재시도 횟수 초과. 요청을 다시 시도했지만 실패했습니다.");
        attempt = 0;
        throw new ApiException(RetrofitErrorCode.NETWORK_NOT_CONNECT, e);
    }

    @Recover
    public Map<String, Object> recover(
            ApiException e,
            String baseUrl,
            String endpoint,
            Map<String, Object> params
    ) {
        attempt = 0;
        throw new ApiException(
                e.getErrorCode(),
                e.getErrorDescription());
    }

    public interface ApiService {
        @POST
        Call<ResponseBody> sendPostRequest(@Url String url, @Body RequestBody body);
    }
}
