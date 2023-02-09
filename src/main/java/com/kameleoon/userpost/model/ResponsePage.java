package com.kameleoon.userpost.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponsePage<T> {
    private List<T> data;
    private ResponseStatus status;
    private PageInfo info;
}
