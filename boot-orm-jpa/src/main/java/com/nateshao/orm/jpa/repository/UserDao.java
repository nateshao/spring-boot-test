package com.nateshao.orm.jpa.repository;

import com.nateshao.orm.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date Created by 邵桐杰 on 2021/7/1 21:08
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

}