package com.example.dao;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author baoguangyu
 * @version 1.0
 * @date 2021/3/12 10:57
 */
public interface UserDao extends
        JpaRepository<User,Long>,//SpringDataJPA提供的简单数据操作接口
        JpaSpecificationExecutor<User>, //SpringDataJPA提供的复杂查询接口
        Serializable {

}
