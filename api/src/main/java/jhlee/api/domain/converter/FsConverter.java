package jhlee.api.domain.converter;

import jhlee.api.common.annoation.Converter;
import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.model.FsResponse;
import jhlee.api.domain.model.FsTickerRequest;
import lombok.RequiredArgsConstructor;
import org.quant_invest.db.entity.FsEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class FsConverter {

    public FsEntity toEntity(FsTickerRequest fsTickerRequest){

        return Optional.ofNullable(fsTickerRequest)
                .map(it ->{
                    return FsEntity.builder()
                            .ticker(fsTickerRequest.getTicker())
                            .date(fsTickerRequest.getDate())
                            .build();
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "fsId Null"))
                ;
    }

    public FsResponse toResponse(FsEntity fsEntity) {

        return Optional.ofNullable(fsEntity)
                .map(it ->{
                    return FsResponse.builder()
                            .ticker(fsEntity.getTicker())
                            .date(fsEntity.getDate())
                            .account(fsEntity.getAccount())
                            .value(fsEntity.getValue())
                            .freq(fsEntity.getFreq())
                            .build();
                })
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "FsEntity Null"))
                ;
    }
}
