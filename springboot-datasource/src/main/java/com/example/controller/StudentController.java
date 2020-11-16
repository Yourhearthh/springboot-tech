package com.example.controller;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 13:35
 * @version: 1.0
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("querystudentsfrommysql")
    public List<Map<String, Object>> queryStudentsFromMysql(){
        return this.studentService.getAllStudentFromMysql();
    }

    @RequestMapping("queryStudentsFromPostgres")
    public List<Map<String, Object>> queryStudentsFromPostgres(){
        return this.studentService.getAllStudentFromPostgres();
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }


}
