package com.kameleoon.userpost.service;

import com.kameleoon.userpost.model.UserDto;

public interface UserService {
    UserDto findUser(String login);
    UserDto saveUser(UserDto user);

    UserDto authenticate(UserDto user);
}
