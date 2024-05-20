package jhlee.api.domain.serviceImpl;

import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.error.UserErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.quant_invest.db.Entity.UserEntity;
import org.quant_invest.db.Repository.UserRepository;
import org.quant_invest.db.enums.UserStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserEntity register(UserEntity userEntity){
        return Optional.ofNullable(userEntity)
                .map(it ->{
                    userEntity.setStatus(UserStatus.REGISTERED);
                    userEntity.setRegisteredAt(LocalDateTime.now());
                    return userRepository.save(userEntity);
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "UserEntity Null"))
                ;
    }

    public UserEntity login(
            String email,
            String password
    ){
        var entity = getUserWithThrow(email, password);
        return entity;
    }

    public UserEntity getUserWithThrow(
            String email,
            String password
    ){
        return userRepository.findFirstByEmailAndPasswordAndStatusOrderByIdDesc(
                email,
                password,
                UserStatus.REGISTERED
        ) .orElseThrow(()-> new ApiException(UserErrorCode.USER_NOT_FOUND));
    }

    public UserEntity getUserWithThrow(
            Long userId
    ){
        return userRepository.findFirstByIdAndStatusOrderByIdDesc(
                userId,
                UserStatus.REGISTERED
        ).orElseThrow(()-> new ApiException(UserErrorCode.USER_NOT_FOUND));
    }
}
