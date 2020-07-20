package com.nateshao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date Created by 邵桐杰 on 2020/7/20 23:12
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 */
@RestController
public class DemoController {

    @GetMapping("/")
    public String Demo(){
        return "Hello spring boot";
    }
}
