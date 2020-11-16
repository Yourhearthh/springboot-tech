package com.example.student.repository;

import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 16:46
 * @version: 1.0
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
