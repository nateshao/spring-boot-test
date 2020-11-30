package com.nateshao.service;

import com.nateshao.entity.User;

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
public interface IUserService {
    /**
     * 保存用户
     *
     * @param user 用户实体
     * @return 保存成功 {@code true} 保存失败 {@code false}
     */
    Boolean save(User user);

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return 删除成功 {@code true} 删除失败 {@code false}
     */
    Boolean delete(Long id);

    /**
     * 更新用户
     *
     * @param user 用户实体
     * @param id   主键id
     * @return 更新成功 {@code true} 更新失败 {@code false}
     */
    Boolean update(User user, Long id);

    /**
     * 获取单个用户
     *
     * @param id 主键id
     * @return 单个用户对象
     */
    User getUser(Long id);

    /**
     * 获取用户列表
     *
     * @param user 用户实体
     * @return 用户列表
     */
    List<User> getUser(User user);

}