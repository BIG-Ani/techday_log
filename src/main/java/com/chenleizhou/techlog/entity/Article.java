package com.chenleizhou.techlog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {

    private Long id;

    private String avatar;

    private String image;

    private String title;

    private String author;

    private Long authorId;

    private String content;

    private Date updateTime;

}
