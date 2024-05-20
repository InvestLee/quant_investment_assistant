package jhlee.api.domain.service;

import jhlee.api.domain.model.TokenDto;

public interface TokenService {

    public TokenDto issueAccessToken(Long userId);

    public TokenDto issueRefreshToken(Long userId);

    public Long validationToken(String token);
}
