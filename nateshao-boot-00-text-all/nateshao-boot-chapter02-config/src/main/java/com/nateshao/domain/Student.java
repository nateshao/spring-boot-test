package com.nateshao.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2020/9/13 23:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Component  // 用于将Student类作为Bean注入到Spring容器中
public class Student {
    @Value("${person.id}")
    private int id;      //id
    @Value("${person.name}")
    private String name; //名称
    private List hobby;  //爱好
    private String[] family; //家庭成员
    private Map map;
    private Pet pet;   //宠物

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby=" + hobby +
                ", family=" + Arrays.toString(family) +
                ", map=" + map +
                ", pet=" + pet +
                '}';
    }
}

