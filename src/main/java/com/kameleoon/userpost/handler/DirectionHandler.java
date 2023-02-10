package com.kameleoon.userpost.handler;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DirectionHandler {
    private static final String DESC = "desc";
    public static Sort getDirection(Sort sort, String direction) {
        return direction.toLowerCase().equals(DESC) ? sort.descending() : sort.ascending();
    }
}
