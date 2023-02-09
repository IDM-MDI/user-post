package com.kameleoon.userpost.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponsePage<T> {
    private List<T> data;
    private ResponseStatus status;
    private PageInfo info;
}
