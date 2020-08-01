# nateshao-boot-07-exception

> 此 demo 演示了如何在Spring Boot中进行统一的异常处理，包括了两种方式的处理：第一种对常见API形式的接口进行异常处理，统一封装返回格式；第二种是对模板页面请求的异常处理，统一处理错误页面。

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
    <artifactId>nateshao-boot-07-exception</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nateshao-boot-07-exception</name>
    <description>Demo project for Spring Boot 异常处理</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
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

## R.java

```java
package com.nateshao;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2020/7/30 23:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Data
@AllArgsConstructor
public class R {

    private Integer code;
    private String msg;
    private Object data;

}
```

## DemoController.java

> 统一的API格式返回封装，里面涉及到的 `BaseException` 和`Status` 这两个类，具体代码见 demo。

```java
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
    public R demo(){
        return new R(1,null,"Hello Springboot");
    }

}
```

运行结果：

![4](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/4.png)





# 采用封装处理：

## R.java

```java
package com.nateshao;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2020/7/30 23:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Data
@AllArgsConstructor
public class R {

    private Integer code;
    private String msg;
    private Object data;

    public static R success(Object data){
        return new R(1,null,data);
    }

    public static R fail(String msg,Object data){
        return new R(-1,msg,data);
    }
}
```

## DemoController.java

```java
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
    public R demo(){
        return R.success("hello spring boot");
    }

}
```

![1](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/1.png)

## GlobaleExceptionHander.java 全局异常

```java
package com.nateshao.config;

import com.nateshao.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date Created by 邵桐杰 on 2020/8/1 11:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Slf4j
@ControllerAdvice
public class GlobaleExceptionHander {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R execpetion(Exception e){
        return R.fail(e.getLocalizedMessage(),null);
    }
}
```

![2](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/2.png)



