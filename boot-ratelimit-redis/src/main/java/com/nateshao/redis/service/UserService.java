package com.nateshao.redis.service;

import com.nateshao.redis.pojo.User;

/**
 * @date Created by 邵桐杰 on 2021/12/23 13:56
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface UserService {

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int userId);

    User getUserId(int userId);
}
