package com.chenleizhou.techlog.service;

import com.chenleizhou.techlog.entity.Article;
import com.chenleizhou.techlog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements ArticleMapper {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.getAllArticles();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }


}
