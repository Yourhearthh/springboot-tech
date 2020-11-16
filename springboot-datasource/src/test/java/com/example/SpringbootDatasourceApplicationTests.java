package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringbootDatasourceApplicationTests {

    @Autowired
    @Qualifier("mysqldatasource")
    DataSource dataSourceOne;

    @Autowired
    @Qualifier("postgresqldatasource")
    DataSource dataSourceTwo;

    /**
     * 测试数据库是否连接
     * @throws SQLException
     */
    @Test
    void contextLoads() throws SQLException {
        System.out.println("----------conn" + dataSourceOne.getConnection().getSchema());
        System.out.println("----------conn" + dataSourceTwo.getConnection().getSchema());
    }

}
