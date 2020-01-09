package com.chenleizhou.techlog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {

    private Long id;

    private String title;

    private String author;

    private String content;

    private String category;

    private Date timestamp;

}
