package com.example.dao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 13:26
 * @version: 1.0
 */
public interface PostgresStudentDao {
    List<Map<String, Object>> getAllStudents();
}
