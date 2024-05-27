package jhlee.api.domain.converter;

import jhlee.api.common.annoation.Converter;
import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.model.FearGreedResponse;
import lombok.RequiredArgsConstructor;
import org.quant_invest.db.entity.FearGreedEntity;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class FearGreedConverter {

    public FearGreedEntity toEntity(LocalDate date){

        return Optional.ofNullable(date)
                .map(it ->{
                    return FearGreedEntity.builder()
                            .date(date)
                            .build();
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "date Null"))
                ;
    }

    public FearGreedResponse toResponse(FearGreedEntity fearGreedEntity) {

        return Optional.ofNullable(fearGreedEntity)
                .map(it ->{
                    return FearGreedResponse.builder()
                            .date(fearGreedEntity.getDate())
                            .value(fearGreedEntity.getValue())
                            .build();
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "FearGreedEntity Null"))
                ;
    }
}
