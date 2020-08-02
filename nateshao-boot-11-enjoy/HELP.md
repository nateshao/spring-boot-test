# nateshao-boot-11-enjoy

> 本 demo 主要演示了 Spring Boot 项目如何集成 enjoy 模板引擎。



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
    <artifactId>nateshao-boot-11-enjoy</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nateshao-boot-11-enjoy</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
        <enjoy.version>3.5</enjoy.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.jfinal</groupId>
            <artifactId>enjoy</artifactId>
            <version>${enjoy.version}</version>
        </dependency>

        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>4.1.12</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
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

## EnjoyConfig.java

```java
package com.nateshao.nateshaoboot11enjoy.config;

import com.jfinal.template.ext.spring.JFinalViewResolver;
import com.jfinal.template.source.ClassPathSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date Created by 邵桐杰 on 2020/8/2 12:36
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Configuration
public class EnjoyConfig {
    @Bean(name = "jfinalViewResolver")
    public JFinalViewResolver getJFinalViewResolver() {
        JFinalViewResolver jfr = new JFinalViewResolver();
        // setDevMode 配置放在最前面
        jfr.setDevMode(true);
        // 使用 ClassPathSourceFactory 从 class path 与 jar 包中加载模板文件
        jfr.setSourceFactory(new ClassPathSourceFactory());
        // 在使用 ClassPathSourceFactory 时要使用 setBaseTemplatePath
        // 代替 jfr.setPrefix("/view/")
        JFinalViewResolver.engine.setBaseTemplatePath("/templates/");

        jfr.setSessionInView(true);
        jfr.setSuffix(".html");
        jfr.setContentType("text/html;charset=UTF-8");
        jfr.setOrder(0);
        jfr.addDirective("name",NameDirective.class);
        return jfr;
    }
}
```

## DemoController.java

```java
package com.nateshao.nateshaoboot11enjoy.controller;

import com.nateshao.nateshaoboot11enjoy.vo.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/8/2 12:48
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Controller
public class DemoController {

    @GetMapping
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("username","nateshao");
        modelAndView.setViewName("index");
        SysUser sysUser = new SysUser(1,"nateshao1111");
        SysUser sysUser1 = new SysUser(1,"nateshao2222");
        SysUser sysUser2 = new SysUser(1,"nateshao3333");
        SysUser sysUser3 = new SysUser(1,"nateshao4444");

        List<SysUser> userList = new ArrayList<>();
        userList.add(sysUser);
        userList.add(sysUser1);
        userList.add(sysUser2);
        userList.add(sysUser3);

        modelAndView.addObject("userList",userList);
        modelAndView.addObject("date",new Date());

        return modelAndView;
    }
}
```

## NameDirective.java

```java
package com.nateshao.nateshaoboot11enjoy.config;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import org.apache.tomcat.jni.Directory;

import java.io.IOException;

/**
 * @date Created by 邵桐杰 on 2020/8/2 14:08
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
public class NameDirective extends Directive {


    @Override
    public void exec(Env env, Scope scope, Writer writer) {
       try {
           writer.write("我是自定义指令");
       }catch (IOException e){
           e.printStackTrace();
       }
    }
}
```

```java
package com.nateshao.nateshaoboot11enjoy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2020/8/2 12:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Data
@AllArgsConstructor
public class SysUser {
    private Integer id;
    private String name;
}
```


## index.html

```jsp
<!--

#for(sysUser:arrayList)
    #(sysUser.name)
#end
-->

#include('header.html',title='文件头---')
#date(date,'yyyyMMdd')

#if(userList != null)
用户不为空
#end



#name()
```

## header.html

```jsp
文件头

#(title)
```

## Enjoy 语法糖学习文档

http://www.jfinal.com/doc/6-1



