package com.example.student.service;

import com.example.student.entity.Student;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 16:46
 * @version: 1.0
 */
public interface StudentService {
    List<Student> findAll();
}
