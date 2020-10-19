package com.nateshao.nateshaobootchapter05mvc.config;

import com.nateshao.nateshaobootchapter05mvc.servletComponent.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date Created by 邵桐杰 on 2020/10/19 20:16
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(myServlet, "/myServlet");

        return registrationBean;
    }













}
