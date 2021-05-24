package com.nateshao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @date Created by 邵桐杰 on 2020/9/13 23:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Configuration
@Profile("dev")    // 指定多环境配置类标识
public class DevDBConnector implements DBConnector {
    @Override
    public void configure() {
        System.out.println("数据库配置环境dev");
    }
}

