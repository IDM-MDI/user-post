package com.kameleoon.userpost.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private long id;
    private String text;
    private UserDto user;
    private long likeCount;
    private long dislikeCount;
    private LocalDateTime postedDate;
}
