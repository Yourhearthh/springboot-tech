package com.example.service.impl;

import com.example.entity.Article;
import com.example.mapper.ArticleMapper;
import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-17 09:28
 * @version: 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public int add(Article article) {
        return articleMapper.add(article);
    }

    @Override
    public int update(Article article) {
        return articleMapper.update(article);
    }

    @Override
    public int deleteById(Long id) {
        return articleMapper.deleteById(id);
    }

    @Override
    public Article queryArticleById(Long id) {
        return articleMapper.findStudentById(id);
    }
}
