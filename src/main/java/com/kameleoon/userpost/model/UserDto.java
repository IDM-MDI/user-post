package com.kameleoon.userpost.model;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String login;
    private String password;
}
