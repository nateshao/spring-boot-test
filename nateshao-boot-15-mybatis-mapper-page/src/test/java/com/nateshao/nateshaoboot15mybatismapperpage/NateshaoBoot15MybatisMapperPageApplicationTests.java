package com.nateshao.nateshaoboot15mybatismapperpage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nateshao.nateshaoboot15mybatismapperpage.domain.User;
import com.nateshao.nateshaoboot15mybatismapperpage.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class NateshaoBoot15MybatisMapperPageApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.selectAll());
    }

    @Test
    void insert(){
        User user = new User();
        user.setUsername("nateshaoooo");
        user.setPassword("aaaaa");
        System.out.println((userMapper.insert(user)));
        System.out.println(user.getId());
    }

    @Test
    void query(){
        User user = new User();
        user.setUsername("nateshao");
        List<User> users = userMapper.select(user);
        System.out.println(users);
//        System.out.println((userMapper.select(user)));
    }

    // 测试分页
    @Test
    void page(){

        PageHelper.startPage(1,3);
        List<User> users = userMapper.selectAll();

        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println(pageInfo);

    }

}
