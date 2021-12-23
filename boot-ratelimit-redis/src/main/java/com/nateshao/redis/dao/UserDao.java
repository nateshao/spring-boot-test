package com.nateshao.redis.dao;

import com.nateshao.redis.pojo.User;

/**
 * @date Created by 邵桐杰 on 2021/12/23 15:02
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface UserDao {
    /**
     * 用户数据新增
     */
    void addUser(User user);

    User getUserId(int userId);

    void updateUser(User user);

    void deleteUser(int userId);
}
