package com.nateshao.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.nateshao.constant.Const;
import com.nateshao.dao.UserDao;
import com.nateshao.entity.User;
import com.nateshao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/11/30 12:34
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description：
 */
@Service
public class UserServiceImpl implements IUserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 保存用户
     *
     * @param user 用户实体
     * @return 保存成功 {@code true} 保存失败 {@code false}
     */
    @Override
    public Boolean save(User user) {
        String rawPass = user.getPassword();
        String salt = IdUtil.simpleUUID();
        String pass = SecureUtil.md5(rawPass + Const.SALT_PREFIX + salt);
        user.setPassword(pass);
        user.setSalt(salt);
        return userDao.insert(user) > 0;
    }

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return 删除成功 {@code true} 删除失败 {@code false}
     */
    @Override
    public Boolean delete(Long id) {
        return userDao.delete(id) > 0;
    }

    /**
     * 更新用户
     *
     * @param user 用户实体
     * @param id   主键id
     * @return 更新成功 {@code true} 更新失败 {@code false}
     */
    @Override
    public Boolean update(User user, Long id) {
        User exist = getUser(id);
        if (StrUtil.isNotBlank(user.getPassword())) {
            String rawPass = user.getPassword();
            String salt = IdUtil.simpleUUID();
            String pass = SecureUtil.md5(rawPass + Const.SALT_PREFIX + salt);
            user.setPassword(pass);
            user.setSalt(salt);
        }
        BeanUtil.copyProperties(user, exist, CopyOptions.create().setIgnoreNullValue(true));
        exist.setLastUpdateTime(new DateTime());
        return userDao.update(exist, id) > 0;
    }

    /**
     * 获取单个用户
     *
     * @param id 主键id
     * @return 单个用户对象
     */
    @Override
    public User getUser(Long id) {
        return userDao.findOneById(id);
    }

    /**
     * 获取用户列表
     *
     * @param user 用户实体
     * @return 用户列表
     */
    @Override
    public List<User> getUser(User user) {
        return userDao.findByExample(user);
    }
}

