package com.nateshao.nateshaoboot16mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nateshao.nateshaoboot16mybatisplus.domain.User;
import com.nateshao.nateshaoboot16mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NateshaoBoot16MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        System.out.println(users);

    }
    @Test
    void queryOne() {
        User user = new User();
        user.setUsername("nateshao");
        List<User> users = userMapper.selectList(new QueryWrapper<>(user));

        System.out.println(users);

    }

    @Test
    void lambadaQueryOne() {
        List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getUsername, "nateshao"));
        System.out.println(users);
    }
    @Test
    void Query3() {
        // 分页查询
        IPage<User> page = new Page<>(1, 3);
        IPage<User> page1 = userMapper.selectPage(page, new QueryWrapper<>());
        System.out.println(page1.getRecords());

        System.out.println(page1.getTotal());

    }
    @Test
    void Query4() {
        // ActiveRecord
        List<User> users = new User().selectAll();
        System.out.println(users);
    }

}
