package com.kameleoon.userpost.handler;

import com.kameleoon.userpost.model.ResponseStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseStatusHandler {
    public static ResponseStatus deleteStatus() {
        return new ResponseStatus();
    }
    public static ResponseStatus saveStatus() {
        return new ResponseStatus();
    }

    public static ResponseStatus updateStatus() {
        return new ResponseStatus();
    }

    public static ResponseStatus findByPageStatus() {
        return new ResponseStatus();
    }
}
