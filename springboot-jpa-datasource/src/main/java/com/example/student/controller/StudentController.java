package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 16:46
 * @version: 1.0
 */
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }
}
