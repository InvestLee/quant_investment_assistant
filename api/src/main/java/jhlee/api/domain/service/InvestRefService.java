package jhlee.api.domain.service;

import org.quant_invest.db.entity.FearGreedEntity;
import org.quant_invest.db.entity.YieldEntity;

import java.util.List;

public interface InvestRefService {

    public FearGreedEntity getRecentFearGreed();

    public YieldEntity getRecentYield();

    public List<YieldEntity> getAllYield();
}
