package com.nateshao.controller;

import com.nateshao.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date Created by 邵桐杰 on 2020/7/30 23:48
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@RestController
public class DemoController {
    @GetMapping
    public R demo(Integer num) {

        if (1 == num) {
            throw new RuntimeException("测试异常");
        }
        return R.success("hello spring boot");
    }

}
