package com.zikri.twitter.service;

import com.zikri.twitter.dto.*;
import com.zikri.twitter.entity.User;
import com.zikri.twitter.repository.UserRepository;
import com.zikri.twitter.security.BCrypt;
import com.zikri.twitter.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    @Autowired
    ValidationService validationService;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) {
        validationService.validate(loginRequest);

        User user = userRepository
                .findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or Password wrong"));

        if (BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
            UserResponse userResponse = userService.convertToUserResponse(user);
            String accessToken = jwtUtil.generateToken(userResponse);

            return LoginResponse.builder().user(userResponse).accessToken(accessToken).expiredAt(JwtUtil.EXPIRATION_TIME).build();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or Password wrong");
        }
    }


    public RegisterResponse register(RegisterRequest registerRequest) {
        validationService.validate(registerRequest);

        User user = new User();
        user.setUsername(registerRequest.getName());
        user.setName(registerRequest.getUsername());
        user.setPassword(BCrypt.hashpw(registerRequest.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);

        UserResponse userResponse = userService.convertToUserResponse(user);
        String accessToken = jwtUtil.generateToken(userResponse);

        return RegisterResponse.builder().user(userResponse).accessToken(accessToken).expiredAt(JwtUtil.EXPIRATION_TIME).build();
    }


}
