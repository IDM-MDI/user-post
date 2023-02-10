package com.kameleoon.userpost.controller;

import com.kameleoon.userpost.model.UserDto;
import com.kameleoon.userpost.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @PostMapping
    public UserDto registration(@RequestBody UserDto user) {
        return service.saveUser(user);
    }
}
