package jhlee.api.domain.converter;

import jhlee.api.common.annoation.Converter;
import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.model.UserRegisterRequest;
import jhlee.api.domain.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.quant_invest.db.entity.UserEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class UserConverter {

    public UserEntity toEntity(UserRegisterRequest request){

        return Optional.ofNullable(request)
                .map(it ->{
                    return UserEntity.builder()
                            .name(request.getName())
                            .email(request.getEmail())
                            .password(request.getPassword())
                            .address(request.getAddress())
                            .build();
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "UserRegisterRequest Null"))
                ;
    }

    public UserResponse toResponse(UserEntity userEntity) {

        return Optional.ofNullable(userEntity)
                .map(it ->{
                    return UserResponse.builder()
                            .id(userEntity.getId())
                            .name(userEntity.getName())
                            .status(userEntity.getStatus())
                            .email(userEntity.getEmail())
                            .address(userEntity.getAddress())
                            .registeredAt(userEntity.getRegisteredAt())
                            .unregisteredAt(userEntity.getUnregisteredAt())
                            .lastLoginAt(userEntity.getLastLoginAt())
                            .build();
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "UserEntity Null"))
                ;
    }
}
