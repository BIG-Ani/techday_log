package com.chenleizhou.techlog.service;

import com.alibaba.fastjson.JSON;
import com.chenleizhou.techlog.entity.Article;
import com.chenleizhou.techlog.mapper.ArticleMapper;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ArticleService implements ArticleMapper {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.getAllArticles();
    }

//    @Override
//    @Cacheable(cacheNames = {"article"}, key = "#root.args[0]")
//    public Article getArticleById(Integer id) {
//        System.out.println("cache checking>>>:" + "look up the " + id + " article");
//        return articleMapper.getArticleById(id);
//    }

    /**
     * @Description: set the redis cache manager
     * @Params: article id
     * @Return: return data from redis if db had the record,
     * or return from the mysql by using articleMapper
     * @Time: 1/9/20
    **/
    @Override
    public Article getArticleById(Integer id) {
        // get the record with the key
        String redisKey = "article:" + id;  // article the name of the db manager
        String json = (String) redisTemplate.opsForValue().get(redisKey);
        Article article = null;

        // retrieve data from cache if redis had
        if (Strings.isNullOrEmpty(json)) {
            article = articleMapper.getArticleById(id);

            // serialize the data before setting the redis value
            String articleStr = JSON.toJSONString(article);
            System.out.println("redis cache checking>>> \n" + articleStr);

            redisTemplate.opsForValue().set(redisKey, articleStr);
            redisTemplate.expire(redisKey, 5, TimeUnit.MINUTES);
        } else {
            article = JSON.parseObject(json, Article.class);
        }

        return article;
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
