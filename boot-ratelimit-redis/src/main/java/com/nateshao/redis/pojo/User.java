package com.nateshao.redis.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @date Created by 邵桐杰 on 2021/12/23 13:57
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    public User() {
    }


    /**
     * 获取编号
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}

