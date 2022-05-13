package com.kms.self203.backend203self.security.services;

import com.kms.self203.backend203self.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userService.findUserByUsername(username).map(
                 UserDetailsImpl::build)
                 .orElseThrow(() -> new UsernameNotFoundException("Not found User with username: " + username));
    }
}
