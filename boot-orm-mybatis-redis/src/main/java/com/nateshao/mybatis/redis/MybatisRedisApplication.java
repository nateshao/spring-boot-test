package com.nateshao.mybatis.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @date Created by 邵桐杰 on 2021/12/24 18:08
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@MapperScan("com.nateshao.mybatis.redis.mapper")
@SpringBootApplication
public class MybatisRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisRedisApplication.class, args);
    }
}
