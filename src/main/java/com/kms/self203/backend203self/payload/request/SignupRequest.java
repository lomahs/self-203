package com.kms.self203.backend203self.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String username;

    private String email;

    private Set<String> roles;

    private String password;
}
