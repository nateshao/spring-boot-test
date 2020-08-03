# nateshao-boot-16-mybatis-plus

> 此 demo 演示了 Spring Boot 如何集成通用Mapper插件和分页助手插件，简化Mybatis开发，带给你难以置信的开发体验。

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
    <artifactId>nateshao-boot-16-mybatis-plus</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nateshao-boot-16-mybatis-plus</name>
    <description>nateshao-boot-16-mybatis-plus</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.3.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
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

## User.java

```java
package com.nateshao.nateshaoboot16mybatisplus.domain;
       
       import com.baomidou.mybatisplus.extension.activerecord.Model;
       import lombok.Data;
       
       /**
        * @date Created by 邵桐杰 on 2020/8/3 22:46
        * @微信公众号 千羽的编程时光
        * @个人网站 www.nateshao.cn
        * @博客 https://nateshao.gitee.io
        * @GitHub https://github.com/nateshao
        * @Gitee https://gitee.com/nateshao
        */
       @Data
       public class User {
           private Integer id;
           private String username;
           private String password;
       }

```

## UserMapper.java

```java
package com.nateshao.nateshaoboot15mybatismapperpage.mapper;

import com.nateshao.nateshaoboot15mybatismapperpage.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @date Created by 邵桐杰 on 2020/8/3 21:43
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
```

## UserMapper.java

```java
package com.nateshao.nateshaoboot16mybatisplus.mapper;
       
       import com.baomidou.mybatisplus.core.mapper.BaseMapper;
       import com.nateshao.nateshaoboot16mybatisplus.domain.User;
       import org.apache.ibatis.annotations.Mapper;
       
       /**
        * @date Created by 邵桐杰 on 2020/8/3 22:47
        * @微信公众号 千羽的编程时光
        * @个人网站 www.nateshao.cn
        * @博客 https://nateshao.gitee.io
        * @GitHub https://github.com/nateshao
        * @Gitee https://gitee.com/nateshao
        */
       @Mapper
       public interface UserMapper extends BaseMapper<User> {
       
       }

```
### NateshaoBoot16MybatisPlusApplicationTests.java
```java

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        System.out.println(users);

    }
```

--- 

## MyBatisPlusConfig.java
```java
package com.nateshao.nateshaoboot16mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date Created by 邵桐杰 on 2020/8/3 23:28
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Configuration
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
```
### NateshaoBoot16MybatisPlusApplicationTests.java
```java
 @Test
    void queryOne() {
        User user = new User();
        user.setUsername("nateshao");
        List<User> users = userMapper.selectList(new QueryWrapper<>(user));

        System.out.println(users);

    }

    @Test
    void lambadaQueryOne() {
        List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getUsername, "nateshao"));
        System.out.println(users);
    }
    @Test
    void Query3() {
        // 分页查询
        IPage<User> page = new Page<>(1, 3);
        IPage<User> page1 = userMapper.selectPage(page, new QueryWrapper<>());
        System.out.println(page1.getRecords());

        System.out.println(page1.getTotal());

    }
```
# ActiveRecord
```java
package com.nateshao.nateshaoboot16mybatisplus.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2020/8/3 22:46
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Data
public class User extends Model<User> {
    private Integer id;
    private String username;
    private String password;
}
```
### NateshaoBoot16MybatisPlusApplicationTests.java
```java

    @Test
    void Query4() {
        // ActiveRecord
        List<User> users = new User().selectAll();
        System.out.println(users);
    }
```

## 参考

- 通用Mapper官方文档：https://github.com/abel533/Mapper/wiki/1.integration
- pagehelper 官方文档：https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md