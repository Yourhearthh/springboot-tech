package com.example.mapper;

import com.example.entity.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2020-11-17 09:16
 * @version: 1.0
 */
@Component
@Mapper
public interface ArticleMapper {
    @Insert("insert into article(id,name,age) values (#{id},#{name},#{age})")
    int add(Article student);

    @Update("update article set id=#{id},name=#{name},sno=#{age}}")
    int update(Article article);

    @Delete("delete from article where id=#{id}")
    int deleteById(Long id);

    @Select("select * article where id=#{id}")
    Article findStudentById(Long id);
}
