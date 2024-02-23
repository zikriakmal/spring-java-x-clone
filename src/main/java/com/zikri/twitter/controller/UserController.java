package com.zikri.twitter.controller;

import com.zikri.twitter.dto.UserResponse;
import com.zikri.twitter.dto.WebResponse;
import com.zikri.twitter.entity.User;
import com.zikri.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(
            path = "/api/v1/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<UserResponse>> getUser(UserResponse user) {
        List<UserResponse> userResponse = userService.getAll();
        return WebResponse.<List<UserResponse>>builder().data(userResponse).build();
    }

}
