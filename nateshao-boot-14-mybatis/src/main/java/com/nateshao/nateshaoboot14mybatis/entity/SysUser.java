package com.nateshao.nateshaoboot14mybatis.entity;

import java.io.Serializable;

/**
 * @date Created by 邵桐杰 on 2020/8/3 9:07
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 604028956254506996L;

    private Integer userId;

    private String username;

    private String password;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}