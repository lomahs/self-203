package com.kms.self203.backend203self.service.impl;

import com.kms.self203.backend203self.entity.Account;
import com.kms.self203.backend203self.repository.IAccountRepository;
import com.kms.self203.backend203self.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Optional<Account> getById(String key) {
        return accountRepository.findById(key);
    }

    @Override
    public Account save(Account entity) {
        return null;
    }

    @Override
    public void remove(Account entity) {

    }

    @Override
    public void removeById(String key) {

    }
}
