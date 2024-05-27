package jhlee.api.domain.service;

import org.quant_invest.db.entity.FsEntity;

import java.util.List;

public interface FsService {

    public List<FsEntity> getRecentFs(String ticker);
}
