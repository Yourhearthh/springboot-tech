package com.example.controller;

import com.example.entity.Article;
import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-17 09:32
 * @version: 1.0
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping( value = "/findStudentBySno", method = RequestMethod.GET)
    public Article queryStudentBySno(Long id) {
        return this.articleService.queryArticleById(id);
    }

    @RequestMapping( value = "/add", method = RequestMethod.GET)
    public int add(Article article){
        return articleService.add(article);
    }

}
