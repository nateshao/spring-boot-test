package com.nateshao.nateshaoboot17beetlsql.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.HierarchicalMessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date Created by 邵桐杰 on 2020/8/4 0:06
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Configuration
public class BeetlsqlConfig {

    @Bean
    public HikariDataSource hikariDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/user?serverTimezone=UTC");

        return dataSource;
    }

}



















