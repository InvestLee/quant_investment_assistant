package jhlee.api.domain.converter;

import jhlee.api.common.annoation.Converter;
import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.model.YieldResponse;
import lombok.RequiredArgsConstructor;
import org.quant_invest.db.entity.YieldEntity;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class YieldConverter {

    public YieldEntity toEntity(LocalDate date){

        return Optional.ofNullable(date)
                .map(it ->{
                    return YieldEntity.builder()
                            .date(date)
                            .build();
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "date Null"))
                ;
    }

    public YieldResponse toResponse(YieldEntity yieldEntity) {

        return Optional.ofNullable(yieldEntity)
                .map(it ->{
                    return YieldResponse.builder()
                            .date(yieldEntity.getDate())
                            .t10y2y(yieldEntity.getT10y2y())
                            .t10y3m(yieldEntity.getT10y3m())
                            .t10yie(yieldEntity.getT10yie())
                            .build();
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "YieldEntity Null"))
                ;
    }
}
