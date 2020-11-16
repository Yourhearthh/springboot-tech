package com.example.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName:
 * @Description: 多数据源配置类，根据application.yml分别配置一个Mysql和Postgresql的数据源，
 * 并且将这两个数据源注入到两个不同的JdbcTemplate中
 * @author: baoguangyu
 * @date: 2020-11-16 13:23
 * @version: 1.0
 */
@Configuration
public class DataSourceConfig {

    // @Primary标志这个Bean如果在多个同类Bean候选时，该Bean优先被考虑。多数据源配置的时候，必须要有一个主数据源，用@Primary标志该Bean。

    @Primary //主数据源
    @Bean(name = "mysqldatasource")
    @ConfigurationProperties("spring.datasource.druid.mysql")
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "postgresqldatasource")
    @ConfigurationProperties("spring.datasource.druid.postgres")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("mysqldatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "postgresJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("postgresqldatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
