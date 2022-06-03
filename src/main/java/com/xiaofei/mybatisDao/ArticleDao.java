package com.xiaofei.mybatisDao;

import com.xiaofei.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-27, 0:53
 * Description:
 */
@Repository ("mybatisArticleDao")
public interface ArticleDao {
    Article getArticleById(Long id);
    List<Article> getArticleList(Map<String, Object> paramMap);
    Long getTotalAmount(Map<String, Object> paramMap);
    void saveArticle(Article article);
    void updateArticle(Article article);
    void deleteArticleById(Long id);
}
