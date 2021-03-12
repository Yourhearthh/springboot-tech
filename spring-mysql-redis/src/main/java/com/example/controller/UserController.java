package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author baoguangyu
 * @version 1.0
 * @date 2021/3/12 10:55
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value="/list")
    public List<User> list(){
        System.out.println("只有第一次才会打印sql语句");
        return userService.list();
    }

}
