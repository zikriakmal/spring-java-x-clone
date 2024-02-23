package com.zikri.twitter.service.interfaces;

import com.zikri.twitter.dto.LoginRequest;
import com.zikri.twitter.dto.LoginResponse;
import com.zikri.twitter.dto.RegisterRequest;
import com.zikri.twitter.dto.RegisterResponse;

public interface AuthServiceInterface {

    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);
}
