package com.example.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 13:24
 * @version: 1.0
 */
public interface StudentService {
    List<Map<String, Object>> getAllStudentFromMysql();
    List<Map<String, Object>> getAllStudentFromPostgres();
}
