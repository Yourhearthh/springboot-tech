package com.example.student.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-16 16:45
 * @version: 1.0
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SNO", nullable = false)
    private Long id;

    @Column(name = "SNAME")
    private String sname;

    @Column(name = "SSEX")
    private String ssex;

    @Column(name = "DATASOURCE")
    private String datasource;
}
