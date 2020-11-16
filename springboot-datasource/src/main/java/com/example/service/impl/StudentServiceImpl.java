package com.example.service.impl;

import com.example.dao.MysqlStudentDao;
import com.example.dao.PostgresStudentDao;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 13:25
 * @version: 1.0
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    MysqlStudentDao mysqlStudentDao;

    @Autowired
    PostgresStudentDao postgresStudentDao;

    @Override
    public List<Map<String, Object>> getAllStudentFromMysql() {
        return mysqlStudentDao.getAllStudents();
    }

    @Override
    public List<Map<String, Object>> getAllStudentFromPostgres() {
        return postgresStudentDao.getAllStudents();
    }
}
