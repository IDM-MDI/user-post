package com.kameleoon.userpost.exception;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum ExceptionCode {
    JWT_TOKEN_IS_EXPIRED(1002,"123");
    private final int code;
    private final String message;
}
