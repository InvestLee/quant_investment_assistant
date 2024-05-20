package jhlee.api.domain.converter;

import jhlee.api.common.annoation.Converter;
import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.model.TokenDto;
import jhlee.api.domain.model.TokenResponse;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Converter
public class TokenConverter {

    public TokenResponse toResponse(
            TokenDto accessToken,
            TokenDto refreshToken
    ){
        Objects.requireNonNull(accessToken, ()->{throw new ApiException(CommonErrorCode.NULL_POINT);});
        Objects.requireNonNull(refreshToken, ()->{throw new ApiException(CommonErrorCode.NULL_POINT);});

        return TokenResponse.builder()
                .accessToken(accessToken.getToken())
                .accessTokenExpiredAt(accessToken.getExpiredAt())
                .refreshToken(refreshToken.getToken())
                .refreshTokenExpiredAt(refreshToken.getExpiredAt())
                .build();
    }
}
