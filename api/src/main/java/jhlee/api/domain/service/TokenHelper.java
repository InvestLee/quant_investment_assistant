package jhlee.api.domain.service;

import jhlee.api.domain.model.TokenDto;

import java.util.Map;

public interface TokenHelper {

    TokenDto issueAccessToken(Map<String, Object> data);
    TokenDto issueRefreshToken(Map<String, Object> data);
    Map<String, Object> validationTokenWithThrow(String token);
}
