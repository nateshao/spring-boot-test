package com.nateshao.nateshaobootchapter05mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @date Created by 邵桐杰 on 2020/10/19 20:16
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Configuration
public class MyMVCconfig implements WebMvcConfigurer {
    // 添加视图管理
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("toLoginPage").setViewName("login");
        registry.addViewController("login.html").setViewName("login");
    }
}
