package com.kms.self203.backend203self.repository;

import com.kms.self203.backend203self.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, String> {
}
