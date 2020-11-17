package com.example.service;

import com.example.entity.Article;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-17 09:28
 * @version: 1.0
 */
public interface ArticleService {
    int add(Article student);
    int update(Article student);
    int deleteById(Long id);
    Article queryArticleById(Long id);
}
