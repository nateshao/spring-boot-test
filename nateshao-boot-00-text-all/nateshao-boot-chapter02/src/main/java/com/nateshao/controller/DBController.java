package com.nateshao.controller;


import com.nateshao.config.DBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @date Created by 邵桐杰 on 2020/9/13 23:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@RestController
public class DBController {
    @Autowired
    private DBConnector dbConnector;
    @GetMapping("/showDB")
    public void showDB(){
        dbConnector.configure();
    }
}

