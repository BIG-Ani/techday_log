package com.chenleizhou.techlog.mapper;

import com.chenleizhou.techlog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    List<Article> getAllArticles();

    Article getArticleById(Integer id);

    void insertArticle(Article article);

    void deleteArticle(Integer id);
}
