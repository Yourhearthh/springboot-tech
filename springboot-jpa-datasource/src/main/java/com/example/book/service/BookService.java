package com.example.book.service;

import com.example.book.entity.Book;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 16:53
 * @version: 1.0
 */
public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
}
