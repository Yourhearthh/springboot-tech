package com.example.book.repository;

import com.example.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 16:52
 * @version: 1.0
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
