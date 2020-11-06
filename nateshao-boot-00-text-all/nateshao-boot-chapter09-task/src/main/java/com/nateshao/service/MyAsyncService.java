package com.nateshao.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @date Created by 邵桐杰 on 2020/11/6 9:27
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Service
public class MyAsyncService {
    /**************************** 模拟无返回值的异步任务处理 *************************************/
    @Async
    public void sendSMS() throws Exception {
        System.out.println("调用短信验证码业务方法.....");
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        long endTime = System.currentTimeMillis();
        System.out.println("短信业务执行完成耗时：" + (endTime - startTime));
    }

    /**************************** 模拟有返回值的异步任务处理 *************************************/
    @Async
    public Future<Integer> processA() throws Exception {
        System.out.println("开始分析统计A数据..");
        long startTime = System.currentTimeMillis();
        Thread.sleep(4000);
        int count = 123456;
        long endTime = System.currentTimeMillis();
        System.out.println("业务A数据统计耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);

    }

    @Async
    public Future<Integer> processB() throws Exception {
        System.out.println("开始分析并统计业务B数据...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        // 模拟定义一个假的统计结果
        int count = 654321;
        Long endTime = System.currentTimeMillis();
        System.out.println("业务B数据统计耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }


}
