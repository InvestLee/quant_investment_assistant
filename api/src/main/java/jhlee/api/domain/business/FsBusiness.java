package jhlee.api.domain.business;

import jhlee.api.common.annoation.Business;
import jhlee.api.domain.converter.FsConverter;
import jhlee.api.domain.model.FsResponse;
import jhlee.api.domain.model.FsTickerRequest;
import jhlee.api.domain.service.FsService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Business
public class FsBusiness {

    private final FsService fsService;
    private final FsConverter fsConverter;

    public List<FsResponse> getRecentFs(
            String ticker
    ) {
        var fsEntities = fsService.getRecentFs(ticker);
        return fsEntities.stream()
                .map(fsConverter::toResponse)
                .collect(Collectors.toList());
    }
}
