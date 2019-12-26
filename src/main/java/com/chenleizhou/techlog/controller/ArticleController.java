package com.chenleizhou.techlog.controller;

import com.chenleizhou.techlog.entity.Article;
import com.chenleizhou.techlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> allArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable Integer id){
        Article foundArticle = articleService.getArticleById(id);
        return foundArticle;
    }

}
