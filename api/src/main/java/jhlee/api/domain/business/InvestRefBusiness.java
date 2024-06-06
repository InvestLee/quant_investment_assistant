package jhlee.api.domain.business;

import jhlee.api.common.annoation.Business;
import jhlee.api.domain.converter.FearGreedConverter;
import jhlee.api.domain.converter.YieldConverter;
import jhlee.api.domain.model.*;
import jhlee.api.domain.service.InvestRefService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Business
public class InvestRefBusiness {

    private final InvestRefService investRefService;
    private final FearGreedConverter fearGreedConverter;
    private final YieldConverter yieldConverter;

    public YieldResponse getRecentYield() {
        var yieldEntity = investRefService.getRecentYield();
        var response = yieldConverter.toResponse(yieldEntity);
        return response;
    }

    public FearGreedResponse getRecentFearGreed() {
        var fearGreedEntity = investRefService.getRecentFearGreed();
        var response = fearGreedConverter.toResponse(fearGreedEntity);
        return response;
    }

    public List<YieldResponse> getAllYield() {
        var yieldEntity = investRefService.getAllYield();
        return yieldEntity.stream()
                .map(yieldConverter::toResponse)
                .collect(Collectors.toList());
    }
}
