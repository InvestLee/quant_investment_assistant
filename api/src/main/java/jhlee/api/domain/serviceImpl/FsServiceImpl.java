package jhlee.api.domain.serviceImpl;

import jhlee.api.domain.service.FsService;
import lombok.RequiredArgsConstructor;
import org.quant_invest.db.entity.FsEntity;
import org.quant_invest.db.repository.FsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FsServiceImpl implements FsService {

    private final FsRepository fsRepository;

    @Override
    public List<FsEntity> getRecentFs(
            String ticker
    ) {
        return fsRepository.searchRecentFs(ticker);
    }
}
