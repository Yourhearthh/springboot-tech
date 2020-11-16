package com.example.dao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 13:25
 * @version: 1.0
 */
public interface MysqlStudentDao {
    List<Map<String, Object>> getAllStudents();
}
