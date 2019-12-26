package com.chenleizhou.techlog.controller;

import com.chenleizhou.techlog.entity.Article;
import com.chenleizhou.techlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/index")
    public String index(Model model){
        Collection<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
