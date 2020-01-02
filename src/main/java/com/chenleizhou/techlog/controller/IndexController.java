package com.chenleizhou.techlog.controller;

import com.chenleizhou.techlog.entity.Article;
import com.chenleizhou.techlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    private static int RECENT_POSTS = 3;

    @GetMapping("/index")
    public String index(Model model){
        Collection<Article> tempArticles = articleService.getAllArticles();

        Collection<Article> articles = new ArrayList<>();

        if (tempArticles.size() > 3) {
            ArrayList<Article> tempList = new ArrayList<>(tempArticles);

            for (int i = 0; i < RECENT_POSTS; i++) {
                articles.add(tempList.get(tempList.size() - i - 1));
            }
        } else {
            articles = tempArticles;
        }

        model.addAttribute("articles", articles);
        return "index";
    }

    @GetMapping("/articles")
    public String allArticles(Model model){
        Collection<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);

        return "article/articles";
    }

    @GetMapping("/dashboard")
    public String loginToDashboard(Model model){
        Collection<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        return "article/dashboard";
    }
}
