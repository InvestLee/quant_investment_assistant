package jhlee.api.domain.business;

import jhlee.api.common.annoation.Business;
import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.converter.TokenConverter;
import jhlee.api.domain.model.TokenResponse;
import jhlee.api.domain.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.quant_invest.db.Entity.UserEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Business
public class TokenBusiness {

    private final TokenService tokenService;
    private final TokenConverter tokenConverter;

    /**
     * user entity user Id 추출
     * access, refresh token 발행
     * converter -> token response로 변경
     */
    public TokenResponse issueToken(UserEntity userEntity){

        return Optional.ofNullable(userEntity)
                .map(ue -> {
                    return ue.getId();
                })
                .map(userId -> {
                    var accessToken = tokenService.issueAccessToken(userId);
                    var refreshToken = tokenService.issueRefreshToken(userId);
                    return tokenConverter.toResponse(accessToken, refreshToken);
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT));
    }

    public Long validationAccessToken(String accessToken){
        var userId = tokenService.validationToken(accessToken);
        return userId;
    }
}
