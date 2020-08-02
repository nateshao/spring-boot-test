package com.nateshao.nateshaoboot13jpa.dao;

import com.nateshao.nateshaoboot13jpa.domain.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @date Created by 邵桐杰 on 2020/8/2 21:30
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Repository
public interface SysUserDao extends CrudRepository<SysUser, Integer> {

    public SysUser findByUsername(String username);
}
