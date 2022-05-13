package com.kms.self203.backend203self.service.impl;

import com.kms.self203.backend203self.entity.User;
import com.kms.self203.backend203self.repository.IUserRepository;
import com.kms.self203.backend203self.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(String key) {
        return userRepository.findById(key);
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void remove(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void removeById(String key) {
        userRepository.deleteById(key);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByAccountUsername(username);
    }
}
