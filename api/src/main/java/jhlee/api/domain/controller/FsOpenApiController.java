package jhlee.api.domain.controller;

import jakarta.validation.Valid;
import jhlee.api.common.api.Api;
import jhlee.api.domain.business.FsBusiness;
import jhlee.api.domain.model.FsResponse;
import jhlee.api.domain.model.FsTickerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/fs")
public class FsOpenApiController {

    private final FsBusiness fsBusiness;

    @GetMapping("/recent_fs")
    public Api<List<FsResponse>> getRecentFs(
            @RequestParam("ticker") String ticker
            ){
        var response = fsBusiness.getRecentFs(ticker);
        return Api.OK(response);
    }
}
