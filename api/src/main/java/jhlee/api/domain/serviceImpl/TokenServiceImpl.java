package jhlee.api.domain.serviceImpl;

import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.model.TokenDto;
import jhlee.api.domain.service.TokenHelper;
import jhlee.api.domain.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TokenServiceImpl implements TokenService {

    private final TokenHelper tokenHelper;

    public TokenDto issueAccessToken(Long userId){
        var data = new HashMap<String, Object>();
        data.put("userId", userId);
        return tokenHelper.issueAccessToken(data);
    }

    public TokenDto issueRefreshToken(Long userId){
        var data = new HashMap<String, Object>();
        data.put("userId", userId);
        return tokenHelper.issueRefreshToken(data);
    }

    public Long validationToken(String token){
        var map = tokenHelper.validationTokenWithThrow(token);
        var userId = map.get("userId");
        Objects.requireNonNull(userId, ()->{throw new ApiException(CommonErrorCode.NULL_POINT);});
        return Long.parseLong(userId.toString());
    }
}
