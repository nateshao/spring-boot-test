package com.nateshao.nateshaobootchapter05mvc.config;

import com.nateshao.nateshaobootchapter05mvc.servletComponent.MyFilter;
import com.nateshao.nateshaobootchapter05mvc.servletComponent.MyListener;
import com.nateshao.nateshaobootchapter05mvc.servletComponent.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import java.util.Arrays;

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

    @Bean
    public FilterRegistrationBean getFilter(MyFilter myFilter){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(myFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/toLoginPage","/myFilter"));
        return registrationBean;
    }

    // 注册Listener组件
    @Bean
    public ServletListenerRegistrationBean getServletListener(MyListener myListener){

        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean(myListener);

        return registrationBean;
    }










}
