package com.nateshao.controller;

import com.nateshao.service.MyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @date Created by 邵桐杰 on 2020/11/6 9:26
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Controller
public class MyAsyncController {

    @Autowired
    private MyAsyncService myAsyncService;

    @GetMapping("/sendSMS")
    public String sendSMS() throws Exception {
        long startTime = System.currentTimeMillis();
        myAsyncService.sendSMS();
        long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时：" + (endTime - startTime));
        return "success";
    }

}
