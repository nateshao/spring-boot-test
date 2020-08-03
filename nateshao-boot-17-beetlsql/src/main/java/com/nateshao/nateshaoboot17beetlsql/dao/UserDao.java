package com.nateshao.nateshaoboot17beetlsql.dao;

import com.nateshao.nateshaoboot17beetlsql.domain.User;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * @date Created by 邵桐杰 on 2020/8/3 23:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Component
public interface UserDao extends BaseMapper<User> {
}
