package com.nateshao.orm.mybatis.plus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nateshao.orm.mybatis.plus.entity.User;
import com.nateshao.orm.mybatis.plus.mapper.UserMapper;
import com.nateshao.orm.mybatis.plus.service.UserService;
import org.springframework.stereotype.Service;
/**
 * @date Created by 邵桐杰 on 2021/6/30 23:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
