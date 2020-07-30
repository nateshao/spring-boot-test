# nateshao-boot-06-log-aop

> 此 demo 主要是演示如何使用 aop 切面对请求进行日志记录，并且记录 UserAgent 信息。

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.2.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.nateshao</groupId>
    <artifactId>nateshao-boot-06-log-aop</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nateshao-boot-06-log-aop</name>
    <description>Demo project for Spring Boot</description>

    <properties>
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
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>net.minidev</groupId>
            <artifactId>json-smart</artifactId>
        </dependency>
    </dependencies>

    <build>
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



## LogAop2.java

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
```

