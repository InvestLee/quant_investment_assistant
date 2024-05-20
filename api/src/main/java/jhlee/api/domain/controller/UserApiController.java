package jhlee.api.domain.controller;

import jhlee.api.common.annoation.UserSession;
import jhlee.api.common.api.Api;
import jhlee.api.domain.business.UserBusiness;
import jhlee.api.domain.model.User;
import jhlee.api.domain.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserBusiness userBusiness;

    @GetMapping("/me")
    public Api<UserResponse> me(
            @UserSession User user
    ){

        var response = userBusiness.me(user);
        return Api.OK(response);
    }
}
