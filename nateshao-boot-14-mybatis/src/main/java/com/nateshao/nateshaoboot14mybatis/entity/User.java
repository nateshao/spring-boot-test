package com.nateshao.nateshaoboot14mybatis.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-08-03 20:55:12
 */
public class User implements Serializable {
    private static final long serialVersionUID = -34261345919565106L;

    private Integer id;

    private String username;

    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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