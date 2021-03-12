package com.example;

import com.example.service.UserService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMysqlRedisApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        userService.list();
    }

    /**
     * 性能测试
     * 10万次查询，100个线程同时操作list方法
     */
    @Test
    @PerfTest(invocations = 100000, threads = 100)
    public void Test2() {
        userService.list();
    }



}
