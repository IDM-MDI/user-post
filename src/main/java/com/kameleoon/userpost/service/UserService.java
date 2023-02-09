package com.kameleoon.userpost.service;

import com.kameleoon.userpost.model.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto findUser(String login);
    UserDto saveUser(UserDto user);
    UserDto authorization(UserDto user);
}
