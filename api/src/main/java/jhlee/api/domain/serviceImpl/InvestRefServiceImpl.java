package jhlee.api.domain.serviceImpl;

import jhlee.api.common.error.CommonErrorCode;
import jhlee.api.common.exception.ApiException;
import jhlee.api.domain.service.InvestRefService;
import lombok.RequiredArgsConstructor;
import org.quant_invest.db.entity.FearGreedEntity;
import org.quant_invest.db.entity.YieldEntity;
import org.quant_invest.db.repository.FearGreedRepository;
import org.quant_invest.db.repository.YieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InvestRefServiceImpl implements InvestRefService {

    private final YieldRepository yieldRepository;
    private final FearGreedRepository fearGreedRepository;

    @Override
    public FearGreedEntity getRecentFearGreed() {
        return fearGreedRepository.findFirstByOrderByDateDesc()
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "Fear & Greed Null"));
    }

    @Override
    public YieldEntity getRecentYield() {
        return yieldRepository.findFirstByT10yieIsNotNullOrderByDateDesc()
                .orElseThrow(()-> new ApiException(CommonErrorCode.NULL_POINT, "yield Null"));
    }

    @Override
    public List<YieldEntity> getAllYield(){
        return yieldRepository.findAllByT10yieIsNotNullOrderByDateAsc();
    }
}
