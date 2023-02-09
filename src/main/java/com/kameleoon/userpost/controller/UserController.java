package com.kameleoon.userpost.controller;

import com.kameleoon.userpost.model.ResponseStatus;
import com.kameleoon.userpost.model.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @PostMapping
    public UserDto registration(@RequestBody UserDto user) {
        return null;
    }
    @PostMapping("/auth")
    public UserDto authentication(@RequestBody UserDto user) {
        return null;
    }
}
