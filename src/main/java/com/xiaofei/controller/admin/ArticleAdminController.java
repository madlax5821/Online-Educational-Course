package com.xiaofei.controller.admin;

import com.xiaofei.entity.Article;
import com.xiaofei.entity.PageBean;
import com.xiaofei.service.ArticleService;
import com.xiaofei.startup.StartupRunner;
import com.xiaofei.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-30, 21:20
 * Description:
 */
@RequestMapping("/admin/article")
@Controller
public class ArticleAdminController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private StartupRunner runner;
    
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> findArticleList(
            @RequestParam(value = "page",required = false)Integer page,
            @RequestParam(value = "limit",required = false)Integer limit) throws Exception{
        Map<String, Object> paramMap = new HashMap<>();
        PageBean pageBean = new PageBean(page, limit);
        int start = pageBean.getStart();
        paramMap.put("start",start);
        paramMap.put("size",limit);
        
        try {
            List<Article> articleList = articleService.findArticleList(paramMap);
            Long totalAmount = articleService.getTotalAmount(paramMap);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("code",0);
            resultMap.put("data",articleList);
            resultMap.put("count",totalAmount);
            return resultMap;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @RequestMapping("/findArticleById")
    @ResponseBody
    public ResponseResult findArticleById(Long id){
        try {
            Article article = articleService.getArticleById(id);
            return ResponseResult.success(article);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/deleteArticleById")
    @ResponseBody
    public ResponseResult deleteArticleById(Long id){
        try {
            articleService.deleteArticleById(id);
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/saveArticle")
    @ResponseBody
    public ResponseResult saveOrUpdateArticle(Article article){
        Article articleById = articleService.getArticleById(article.getId());
        try {
            if (articleById==null){
                articleService.saveArticle(article);
            }else {
                articleService.updateArticle(article);
            }
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
}
