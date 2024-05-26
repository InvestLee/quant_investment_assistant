package jhlee.api.domain.service;

import org.quant_invest.db.entity.UserEntity;

public interface UserService {

    public UserEntity register(
            UserEntity userEntity
    );

    public UserEntity login(
            String email,
            String password
    );

    public UserEntity getUserWithThrow(
            String email,
            String password
    );

    public UserEntity getUserWithThrow(
            Long userId
    );
}
