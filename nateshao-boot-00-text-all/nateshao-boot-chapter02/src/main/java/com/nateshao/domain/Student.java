package com.nateshao.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

