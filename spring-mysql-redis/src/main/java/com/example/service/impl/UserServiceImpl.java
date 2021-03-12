package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baoguangyu
 * @version 1.0
 * @date 2021/3/12 10:58
 */
@Service
@CacheConfig(cacheNames = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Cacheable(value = "userList")
    public List<User> list() {
        return userDao.findAll();
    }
}
