package jhlee.api.domain.service;

import org.quant_invest.db.entity.FearGreedEntity;
import org.quant_invest.db.entity.YieldEntity;

public interface InvestRefService {

    public FearGreedEntity getRecentFearGreed();

    public YieldEntity getRecentYield();
}
