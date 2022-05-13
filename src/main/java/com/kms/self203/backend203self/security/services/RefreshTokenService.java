package com.kms.self203.backend203self.security.services;

import com.kms.self203.backend203self.entity.RefreshToken;
import com.kms.self203.backend203self.exception.TokenRefreshException;
import com.kms.self203.backend203self.repository.IRefreshTokenRepository;
import com.kms.self203.backend203self.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Value("${app.jwtRefreshExpirationMs}")
    private Long refreshTokenDuration;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRefreshTokenRepository refreshTokenRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(String accountName) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setAccount(accountService.getById(accountName).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDuration));
        refreshToken.setToken(UUID.randomUUID().toString());

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new login request!");
        }

        return token;
    }

    @Transactional
    public void deleteByAccount(String accountName) {
        refreshTokenRepository.deleteByAccount_Username(accountName);
    }
}