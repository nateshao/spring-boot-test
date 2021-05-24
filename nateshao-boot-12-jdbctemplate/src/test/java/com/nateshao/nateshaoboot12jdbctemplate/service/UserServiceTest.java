package com.nateshao.nateshaoboot12jdbctemplate.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @date Created by 邵桐杰 on 2020/8/2 17:35
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void insert() {
        for (int i = 0; i < 10; i++) {
            userService.insert("nateshao", "nateshao123");
        }
    }

    @Test
    void testInsert() {
    }

    @Test
    void delete() {
        userService.delete(1);
    }

    @Test
    void update() {
        userService.update("nateshao332", 1);
    }

    @Test
    void query() {
        userService.query(4);
    }
}