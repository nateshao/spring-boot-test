package com.nateshao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date Created by 邵桐杰 on 2020/9/13 23:17
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */

@RestController     //  该注解为组合注解，等同于Spring中@Controller+@ResponseBody注解
public class HelloController {
    @GetMapping("/hello")  // 该注解等同于Spring框架中@RequestMapping(RequestMethod.GET)注解
    public String hello() {
        return "你好，Spring Boot";
    }
}

