package com.nateshao.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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

    @Async
    public void sendSMS() throws Exception {
        System.out.println("调用短信验证码业务方法.....");
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        long endTime = System.currentTimeMillis();
        System.out.println("短信业务执行完成耗时：" + (endTime - startTime));
    }


}
