# spring-boot-demo-log-aop

> 此 demo 主要是演示如何使用 aop 切面对请求进行日志记录，并且记录 UserAgent 信息。

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<artifactId>spring-boot-demo-log-aop</artifactId>
	<version>1.0.0-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-demo-log-aop</name>
	<description>Demo project for Spring Boot</description>
	<parent>
		<groupId>com.xkcoding</groupId>
		<artifactId>spring-boot-demo</artifactId>
		<version>1. 0.0-SNAPSHOT</version>
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>cn.hutool</groupId>
			<artifactId>hutool-all</artifactId>
		</dependency>

		<!-- 解析 UserAgent 信息 -->
		<dependency>
			<groupId>eu.bitwalker</groupId>
			<artifactId>UserAgentUtils</artifactId>
		</dependency>
	</dependencies>

	<build>
		<finalName>spring-boot-demo-log-aop</finalName>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

![1](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/1.png)



## AopLog.java

```java
package com.nateshao.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**使用 aop 切面记录请求日志信息
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
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Around("execution(public * com.nateshao.controller.*Controller.*(..))")
    public Object around(JoinPoint point) throws Throwable {

//        log.info("请求参数为:" ,httpServletRequest);


        log.info("请求参数为:{}",point.getArgs());

        log.info("请求方法为:{}",point.getSignature().getName());

        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) point;

        Object result = proceedingJoinPoint.proceed();

//        log.info("处理结果为:",result);
        return result;
    }

}





















































@Aspect
@Component
@Slf4j
public class AopLog {
	private static final String START_TIME = "request-start";

	/**
	 * 切入点
	 */
	@Pointcut("execution(public * com.xkcoding.log.aop.controller.*Controller.*(..))")
	public void log() {

	}

	/**
	 * 前置操作
	 *
	 * @param point 切入点
	 */
	@Before("log()")
	public void beforeLog(JoinPoint point) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

		log.info("【请求 URL】：{}", request.getRequestURL());
		log.info("【请求 IP】：{}", request.getRemoteAddr());
		log.info("【请求类名】：{}，【请求方法名】：{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

		Map<String, String[]> parameterMap = request.getParameterMap();
		log.info("【请求参数】：{}，", JSONUtil.toJsonStr(parameterMap));
		Long start = System.currentTimeMillis();
		request.setAttribute(START_TIME, start);
	}

	/**
	 * 环绕操作
	 *
	 * @param point 切入点
	 * @return 原方法返回值
	 * @throws Throwable 异常信息
	 */
	@Around("log()")
	public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
		Object result = point.proceed();
		log.info("【返回值】：{}", JSONUtil.toJsonStr(result));
		return result;
	}

	/**
	 * 后置操作
	 */
	@AfterReturning("log()")
	public void afterReturning() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

		Long start = (Long) request.getAttribute(START_TIME);
		Long end = System.currentTimeMillis();
		log.info("【请求耗时】：{}毫秒", end - start);

		String header = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(header);
		log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
	}
}
```

![运行结果](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/2.png)





```java
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
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;

    @Around("execution(public * com.nateshao.controller.*Controller.*(..))")
    public Object around(JoinPoint point) throws Throwable {

        log.info("请求参数为:{}",point.getArgs());

        log.info("请求方法为:{}",point.getSignature().getName());

        String header = request.getHeader("User-Agent");
        log.info("请求浏览器{}:",header);

        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) point;

        Object result = proceedingJoinPoint.proceed();

//        log.info("处理结果为:",result);
        return result;
    }

}
```

![3](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/3.png)



## TestController.java

```java
/**
 * <p>
 * 测试 Controller
 * </p>
 *
 * @package: com.xkcoding.log.aop.controller
 * @description: 测试 Controller
 * @author: yangkai.shen
 * @date: Created in 2018/10/1 10:10 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
public class TestController {

	/**
	 * 测试方法
	 *
	 * @param who 测试参数
	 * @return {@link Dict}
	 */
	@GetMapping("/test")
	public Dict test(String who) {
		return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
	}

}
```

