package com.nateshao.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @date Created by 邵桐杰 on 2020/7/30 0:18
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 */
@Slf4j

@Aspect
@Component
public class LogAop2 {
    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(demolog)")
    public Object around(JoinPoint point,DemoLog demolog) throws Throwable {

        log.info("请求参数为:{}",point.getArgs());

        log.info("请求方法为:{}",point.getSignature().getName());

        String header = request.getHeader("User-Agent");
        log.info("请求浏览器{}:",header);

        log.info("请求方法名称:",demolog.value());

        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) point;

        Object result = proceedingJoinPoint.proceed();

        log.info("处理结果为:",result);

        return result;
    }

}






































