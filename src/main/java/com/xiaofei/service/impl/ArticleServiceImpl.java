package com.xiaofei.service.impl;

import com.xiaofei.entity.Article;
import com.xiaofei.mybatisDao.ArticleDao;
import com.xiaofei.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-27, 0:57
 * Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    
    @Override
    public Article getArticleById(Long id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public List<Article> findArticleList(Map<String, Object> paramMap) {
        return articleDao.getArticleList(paramMap);
    }
    

    @Override
    public Long getTotalAmount(Map<String, Object> paramMap) {
        return articleDao.getTotalAmount(paramMap);
    }

    @Override
    public void saveArticle(Article article) {
        articleDao.saveArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleDao.deleteArticleById(id);
    }
}
