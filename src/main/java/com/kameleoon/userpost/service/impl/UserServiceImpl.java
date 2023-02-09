package com.kameleoon.userpost.service.impl;

import com.kameleoon.userpost.model.UserDto;
import com.kameleoon.userpost.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto saveUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto authorization(UserDto user) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
