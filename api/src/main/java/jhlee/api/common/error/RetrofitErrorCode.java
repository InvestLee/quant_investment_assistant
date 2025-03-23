package jhlee.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RetrofitErrorCode implements ErrorCode{

    NETWORK_NOT_CONNECT(504, 1504, "네트워크 이슈로 인한 데이터 수신 실패");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
