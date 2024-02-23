package com.zikri.twitter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private UserResponse user;

    private String accessToken;

    private Long expiredAt;
}
