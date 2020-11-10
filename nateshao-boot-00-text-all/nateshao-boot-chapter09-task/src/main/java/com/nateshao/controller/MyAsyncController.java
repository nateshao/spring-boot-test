package com.nateshao.controller;

import com.nateshao.service.MyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @date Created by 邵桐杰 on 2020/11/6 9:26
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@RestController
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

    @GetMapping("/statistics")
    public String statistics() throws Exception {
        long startTime = System.currentTimeMillis();
        Future<Integer> futureA = myAsyncService.processA();
        Future<Integer> futureB = myAsyncService.processB();
        int total = futureA.get() + futureB.get();
        System.out.println("异步任务数据统计汇总结果：" + total);
        long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时：" + (endTime - startTime));
        return "success";
    }

}
