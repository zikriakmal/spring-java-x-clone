package com.zikri.twitter.service;

import com.zikri.twitter.dto.UserResponse;
import com.zikri.twitter.entity.User;
import com.zikri.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> getAll(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::convertToUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getCurrentUser(){
        return UserResponse.builder().username("username").name("name").build();
    }

    public UserResponse convertToUserResponse(User user) {
        // Assuming User entity has fields username and name
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

}
