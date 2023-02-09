package com.kameleoon.userpost.model;

import lombok.Data;

@Data
public class PageInfo {
    private int page;
    private int size;
    private String filter;
    private String direction;
}
