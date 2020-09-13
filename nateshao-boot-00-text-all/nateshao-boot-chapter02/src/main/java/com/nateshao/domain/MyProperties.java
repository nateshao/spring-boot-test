package com.nateshao.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @date Created by 邵桐杰 on 2020/9/13 23:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
//@Component
@Configuration    // 自定义配置类
@EnableConfigurationProperties(MyProperties.class) // 开启对应配置类的属性注入功能
@PropertySource("classpath:test.properties")   // 指定自定义配置文件位置和名称
@ConfigurationProperties(prefix = "test")      // 指定配置文件注入属性前缀
public class MyProperties {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

