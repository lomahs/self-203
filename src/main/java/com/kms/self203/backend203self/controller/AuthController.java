package com.kms.self203.backend203self.controller;

import com.kms.self203.backend203self.entity.RefreshToken;
import com.kms.self203.backend203self.entity.User;
import com.kms.self203.backend203self.payload.request.LoginRequest;
import com.kms.self203.backend203self.payload.response.LoginResponse;
import com.kms.self203.backend203self.security.jwt.JwtUtils;
import com.kms.self203.backend203self.security.services.RefreshTokenService;
import com.kms.self203.backend203self.security.services.UserDetailsImpl;
import com.kms.self203.backend203self.service.IUserService;
import com.kms.self203.backend203self.service.impl.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateToken(userDetails);

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getUsername());

        return ResponseEntity.ok(new LoginResponse(
                jwt,
                refreshToken.getToken(),
                userDetails));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user){

        user.getAccount().setPassword(passwordEncoder.encode(user.getAccount().getPassword()));

        return ResponseEntity.ok(userService.save(user));
    }

}
