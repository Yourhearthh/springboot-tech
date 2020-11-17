package com.example.entity;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-17 09:14
 * @version: 1.0
 */
public class Article implements Serializable {
    private static final long serialVersionUID = -339516038496531943L;
    private Long id;
    private String name;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
