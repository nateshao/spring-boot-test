package com.nateshao.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * @date Created by 邵桐杰 on 2020/7/21 22:58
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 */
@Component
@Endpoint(id = "customEndpoint")
public class CustomEndpoint {

    @ReadOperation
    public String custome() {
        return "hello nateshao!!";
    }
}

