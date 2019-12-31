package com.chenleizhou.techlog.controller;

import com.chenleizhou.techlog.entity.Article;
import com.chenleizhou.techlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable Integer id, Model model){
        Article foundArticle = articleService.getArticleById(id);
        model.addAttribute("foundArticle", foundArticle);

        return "article/detail";
    }

    // === create new article
    @GetMapping("/article")
    public String toAddArticle(){
        return "article/add";
    }

    @PostMapping("/article")
    public String addArticle(Article article){
        articleService.insertArticle(article);

        return "redirect:/articles";
    }

    // === delete article
//    @DeleteMapping("/article/{id}")
//    public String deleteArticle(@PathVariable Integer articleId){
//        articleService.deleteArticle(articleId);
//
//        return "redirect:article/dashboard";
//    }

    // delete emp
    @DeleteMapping("/dashboard/article/{id}")
    public String deleteEmp(@PathVariable Integer id){
        System.out.println(articleService.getArticleById(id));
        articleService.deleteArticle(id);
        return "redirect:/dashboard";
    }
}
