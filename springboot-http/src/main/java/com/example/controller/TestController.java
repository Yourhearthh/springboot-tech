package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/doGetControllerTwo")
    public String doGetControllerTwo(String name, int age) {
        return name + "已经" + age +"岁";
    }


}
