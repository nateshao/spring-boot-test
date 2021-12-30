package com.nateshao.thymeleaf.service;

import com.nateshao.thymeleaf.mapper.UserMapper;
import com.nateshao.thymeleaf.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/30 16:00
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 获取所有
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
    // 新增
    @Override
    public void add(User user) {
        userMapper.add(user);
    }
    // 删除
    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }
    // 修改
    @Override
    public void update(User user) {
        userMapper.update(user);
    }
    // 查询
    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

}