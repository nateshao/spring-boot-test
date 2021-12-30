package com.nateshao.thymeleaf.service;

import com.nateshao.thymeleaf.vo.User;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/30 15:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface UserService {
    // 获取所有
    List<User> findAll();
    // 新增
    void add(User user);
    // 删除
    void delete(int id);
    // 编辑
    void update(User user);
    // 查询
    User findById(int id);
}
