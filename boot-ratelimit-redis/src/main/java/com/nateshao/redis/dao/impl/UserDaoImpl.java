package com.nateshao.redis.dao.impl;

import com.alibaba.fastjson.JSON;
import com.nateshao.redis.dao.UserDao;
import com.nateshao.redis.pojo.User;
import com.nateshao.redis.util.RedisUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @date Created by 邵桐杰 on 2021/12/23 15:02
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private RedisUtil redisUtil;

    @Override
    public void addUser(User user) {
        redisUtil.set(String.valueOf(user.getId()), user.toString());
    }

    @Override
    public User getUserId(int userId) {
        String data = redisUtil.get(String.valueOf(userId)).toString();
        User user = JSON.parseObject(data, User.class);
        return user;
    }

    @Override
    public void updateUser(User user) {
        redisUtil.set(String.valueOf(user.getId()), user.toString());
    }

    @Override
    public void deleteUser(int userId) {
        redisUtil.del(String.valueOf(userId));
    }
}