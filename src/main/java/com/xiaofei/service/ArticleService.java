package com.xiaofei.service;

import com.xiaofei.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-27, 0:56
 * Description:
 */
public interface ArticleService {
    Article getArticleById(Long id);
    List<Article> findArticleList(Map<String, Object> paramMap);
    Long getTotalAmount(Map<String, Object> paramMap);
    void saveArticle(Article article);
    void updateArticle(Article article);
    void deleteArticleById(Long id);
}
