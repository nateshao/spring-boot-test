package com.nateshao.nateshaobootchapter05mvc.servletComponent;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @date Created by 邵桐杰 on 2020/10/19 21:53
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
//@Component
//public class MyListener implements ServletContextListener {
//
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("context initialized！！！！！！！！！！！！！！！！！！！！！！！！");
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("context destoryed..。。。。。。。。。。。。。。。。。。。。。。");
//    }
//}

@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context initialized！！！！！！！！！！！！！！！！！！！！！！！！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destoryed..。。。。。。。。。。。。。。。。。。。。。。");
    }
}



