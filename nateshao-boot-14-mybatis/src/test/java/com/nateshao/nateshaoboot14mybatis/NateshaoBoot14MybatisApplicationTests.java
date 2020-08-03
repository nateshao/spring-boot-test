package com.nateshao.nateshaoboot14mybatis;

import com.nateshao.nateshaoboot14mybatis.dao.UserDao;
import com.nateshao.nateshaoboot14mybatis.domain.SysUser;
import com.nateshao.nateshaoboot14mybatis.entity.User;
import com.nateshao.nateshaoboot14mybatis.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NateshaoBoot14MybatisApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(sysUserMapper.selectAll());
    }

    @Test
    void insert() {
        SysUser user = new SysUser();
        user.setUsername("aaaaa");
        user.setPassword("aaaaaaaaa");
        System.out.println(sysUserMapper.saveSysUser(user));
        System.out.println();

    }

    @Test
    void selectUser(){
        List<User> users = userDao.queryAll(new User());
        System.out.println(users);

    }


}
