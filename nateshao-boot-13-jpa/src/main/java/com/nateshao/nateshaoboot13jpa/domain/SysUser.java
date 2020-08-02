package com.nateshao.nateshaoboot13jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @date Created by 邵桐杰 on 2020/8/2 21:30
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Entity
@Data
@Table(name = "user")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;
}
