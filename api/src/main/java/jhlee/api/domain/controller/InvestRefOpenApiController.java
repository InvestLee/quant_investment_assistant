package jhlee.api.domain.controller;

import jhlee.api.common.api.Api;
import jhlee.api.domain.business.InvestRefBusiness;
import jhlee.api.domain.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/invest_ref")
public class InvestRefOpenApiController {

    private final InvestRefBusiness investRefBusiness;

    @GetMapping("/recent_fear_greed")
    public Api<FearGreedResponse> recentFearGreed(){
        var response = investRefBusiness.getRecentFearGreed();
        return Api.OK(response);
    }

    @GetMapping("/recent_yield")
    public Api<YieldResponse> recentYield(){
        var response = investRefBusiness.getRecentYield();
        return Api.OK(response);
    }
}
