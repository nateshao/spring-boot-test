package com.nateshao.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @date Created by 邵桐杰 on 2020/7/30 0:18
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 */
@Slf4j
@Component
@Aspect
public class LogAop {

    @Around("execution(public * com.nateshao.controller.*Controller.*(..))")
    public Object around(){

        return "";
    }

}
