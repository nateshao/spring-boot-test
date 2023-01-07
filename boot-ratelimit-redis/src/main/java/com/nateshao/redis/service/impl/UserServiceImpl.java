package com.nateshao.redis.service.impl;

import com.nateshao.redis.dao.UserDao;
import com.nateshao.redis.pojo.User;
import com.nateshao.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date Created by 邵桐杰 on 2021/12/23 15:00
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        try {
            userDao.addUser(user);
            flag = true;
        } catch (Exception e) {
            logger.error("新增失败!", e);
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        try {
            userDao.updateUser(user);
            flag = true;
        } catch (Exception e) {
            logger.error("更新失败!", e);
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int userId) {
        boolean flag = false;
        try {
            userDao.deleteUser(userId);
            flag = true;
        } catch (Exception e) {
            logger.error("删除失败!", e);
        }
        return flag;
    }

    @Override
    public User getUserId(int userId) {
        return userDao.getUserId(userId);
    }
}
