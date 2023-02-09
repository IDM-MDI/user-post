package com.kameleoon.userpost.service;

import com.kameleoon.userpost.model.UserDto;

public interface UserService {
    UserDto saveUser(UserDto user);
    UserDto authorization(UserDto user);
}
