package com.nateshao.nateshaoboot13jpa;

import com.nateshao.nateshaoboot13jpa.dao.SysUserDao;
import com.nateshao.nateshaoboot13jpa.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class NateshaoBoot13JpaApplicationTests {


    @Autowired
    private SysUserDao userDao;

    @Test
    void contextLoads() {
        SysUser user = new SysUser();
        user.setUsername("lengleng");
        user.setPassword("paaaxc");

        userDao.save(user);

    }
    @Test
    void delete(){
        SysUser user1 = new SysUser();
        user1.setId(8);
        userDao.delete(user1);
    }
    @Test
    void  testUpd(){
        Optional<SysUser> optional = userDao.findById(4);
        SysUser sysUser = optional.get();

        sysUser.setPassword("newpwd");
        userDao.save(sysUser);
    }
    @Test
    void testQuery(){
//        Iterable<SysUser> all = userDao.findAll();
//        System.out.println(all);

        SysUser byUsername = userDao.findByUsername("1231");

        System.out.println(byUsername);
    }
}
