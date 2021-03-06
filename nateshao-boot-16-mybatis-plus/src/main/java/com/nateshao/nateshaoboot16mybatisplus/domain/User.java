package com.nateshao.nateshaoboot16mybatisplus.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2020/8/3 22:46
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Data
public class User extends Model<User> {
    private Integer id;
    private String username;
    private String password;
}
