package com.kms.self203.backend203self.repository;

import com.kms.self203.backend203self.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByAccountUsername(String username);
}
