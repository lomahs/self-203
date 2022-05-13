package com.kms.self203.backend203self.payload.response;


import com.kms.self203.backend203self.security.services.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String accessToken;

    private final String type = "Bearer";

    private String refreshToken;

    private UserDetailsImpl user;

}
