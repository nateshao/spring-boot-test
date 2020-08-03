package com.nateshao.nateshaoboot17beetlsql;

import com.nateshao.nateshaoboot17beetlsql.dao.UserDao;
import com.nateshao.nateshaoboot17beetlsql.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;

@SpringBootTest
class NateshaoBoot17BeetlsqlApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao.all());
    }
    @Test
    void insert() {
        User user = new User();
        user.setUsername("aaaaaaaaa");
        user.setPassword("qqqqqq");
        userDao.insert(user);
    }


}
