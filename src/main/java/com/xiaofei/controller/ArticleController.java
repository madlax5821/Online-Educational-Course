package com.xiaofei.controller;

import com.xiaofei.entity.Article;
import com.xiaofei.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: xiaofei
 * Date: 2022-05-27, 1:04
 * Description:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping("/{articleId}")
    public String findArticleByArticleId(@PathVariable Long articleId, Model model){
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article",article);
        return "/article";
    }
}
