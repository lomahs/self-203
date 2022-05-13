package com.kms.self203.backend203self.service;

import com.kms.self203.backend203self.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService extends IService<User, String> {

    Optional<User> findUserByUsername(String username);
}
