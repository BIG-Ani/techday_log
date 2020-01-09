package com.chenleizhou.techlog.service;

import com.chenleizhou.techlog.entity.Article;
import com.chenleizhou.techlog.mapper.ArticleMapper;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(cacheNames = {"article"}, key = "#root.args[0]")
    public Article getArticleById(Integer id) {
        System.out.println("cache checking>>>:" + "look up the " + id + " article");
        return articleMapper.getArticleById(id);
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteArticle(id);
    }
}
