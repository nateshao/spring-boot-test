package com.nateshao.nateshaoboot17beetlsql;

import com.nateshao.nateshaoboot17beetlsql.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NateshaoBoot17BeetlsqlApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao.all());
    }

}
