# orm-mybatis-plus

> 此 demo 演示了 Spring Boot 如何集成 mybatis-plus，简化Mybatis开发，带给你难以置信的开发体验。

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>spring-boot-test</artifactId>
        <groupId>org.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>boot-orm-mybatis-plus</artifactId>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <mybatis.plus.version>3.1.0</mybatis.plus.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>${mybatis.plus.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
        </dependency>

        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <finalName>demo-orm-mybatis-plus</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

## MybatisPlusConfig.java

```java
package com.nateshao.orm.mybatis.plus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @date Created by 邵桐杰 on 2021/6/30 23:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Configuration
@MapperScan(basePackages = {"com.nateshao.orm.mybatis.plus.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {
    /**
     * 性能分析拦截器，不建议生产使用
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
```

## CommonFieldHandler.java

```java
package com.nateshao.orm.mybatis.plus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @date Created by 邵桐杰 on 2021/6/30 23:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Slf4j
@Component
public class CommonFieldHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
    }
}
```

## application.yml

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/spring-boot-test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2B8
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
    initialization-mode: always
    continue-on-error: true
    schema:
    - "classpath:db/schema.sql"
    data:
    - "classpath:db/data.sql"
    hikari:
      minimum-idle: 5
      connection-test-query: SELECT 1 FROM DUAL
      maximum-pool-size: 20
      auto-commit: true
      idle-timeout: 30000
      pool-name: SpringBootDemoHikariCP
      max-lifetime: 60000
      connection-timeout: 30000
logging:
  level:
    com.xkcoding: debug
    com.xkcoding.orm.mybatis.plus.mapper: trace
mybatis-plus:
  mapper-locations: classpath:mappers/*.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.xkcoding.orm.mybatis.plus.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  AUTO:"数据库ID自增", INPUT:"用户输入ID",ID_WORKER:"全局唯一ID (数字类型唯一ID)", UUID:"全局唯一ID UUID";
      id-type: auto
      #字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
      field-strategy: not_empty
      #驼峰下划线转换
      table-underline: true
      #是否开启大写命名，默认不开启
      #capital-mode: true
      #逻辑删除配置
      #logic-delete-value: 1
      #logic-not-delete-value: 0
      db-type: mysql
    #刷新mapper 调试神器
    refresh: true
  # 原生配置
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: true
```

## UserMapper.java

```java
package com.nateshao.orm.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nateshao.orm.mybatis.plus.entity.User;
import org.springframework.stereotype.Component;

/**
 * @date Created by 邵桐杰 on 2021/6/30 23:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}
```

## UserService.java

```java
package com.nateshao.orm.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nateshao.orm.mybatis.plus.entity.User;

/**
 * @date Created by 邵桐杰 on 2021/6/30 23:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface UserService extends IService<User> {
}
```

## UserServiceImpl.java

```java
package com.nateshao.orm.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nateshao.orm.mybatis.plus.entity.User;
import com.nateshao.orm.mybatis.plus.mapper.UserMapper;
import com.nateshao.orm.mybatis.plus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @date Created by 邵桐杰 on 2021/6/30 23:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
```

## UserServiceTest.java

```java
package com.nateshao.orm.mybatis.plus.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nateshao.orm.mybatis.plus.OrmMybatisPlusApplication;
import com.nateshao.orm.mybatis.plus.OrmMybatisPlusApplicationTest;
import com.nateshao.orm.mybatis.plus.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @date Created by 邵桐杰 on 2021/6/30 23:59
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Slf4j
public class UserServiceTest extends OrmMybatisPlusApplicationTest {
    @Autowired
    private UserService userService;

    /**
     * 测试Mybatis-Plus 新增
     */
    @Test
    public void testSave() {
        String salt = IdUtil.fastSimpleUUID();
        User testSave3 = User.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).build();
        boolean save = userService.save(testSave3);
        Assert.assertTrue(save);
        log.debug("【测试id回显#testSave3.getId()】= {}", testSave3.getId());
    }

    /**
     * 测试Mybatis-Plus 批量新增
     */
    @Test
    public void testSaveList() {
        List<User> userList = Lists.newArrayList();
        for (int i = 4; i < 14; i++) {
            String salt = IdUtil.fastSimpleUUID();
            User user = User.builder().name("testSave" + i).password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave" + i + "@xkcoding.com").phoneNumber("1730000000" + i).status(1).lastLoginTime(new DateTime()).build();
            userList.add(user);
        }
        boolean batch = userService.saveBatch(userList);
        Assert.assertTrue(batch);
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        log.debug("【userList#ids】= {}", ids);
    }

    /**
     * 测试Mybatis-Plus 删除
     */
    @Test
    public void testDelete() {
        boolean remove = userService.removeById(1L);
        Assert.assertTrue(remove);
        User byId = userService.getById(1L);
        Assert.assertNull(byId);
    }

    /**
     * 测试Mybatis-Plus 修改
     */
    @Test
    public void testUpdate() {
        User user = userService.getById(1L);
        Assert.assertNotNull(user);
        user.setName("MybatisPlus修改名字");
        boolean b = userService.updateById(user);
        Assert.assertTrue(b);
        User update = userService.getById(1L);
        Assert.assertEquals("MybatisPlus修改名字", update.getName());
        log.debug("【update】= {}", update);
    }

    /**
     * 测试Mybatis-Plus 查询单个
     */
    @Test
    public void testQueryOne() {
        User user = userService.getById(1L);
        Assert.assertNotNull(user);
        log.debug("【user】= {}", user);
    }

    /**
     * 测试Mybatis-Plus 查询全部
     */
    @Test
    public void testQueryAll() {
        List<User> list = userService.list(new QueryWrapper<>());
        Assert.assertTrue(CollUtil.isNotEmpty(list));
        log.debug("【list】= {}", list);
    }

    /**
     * 测试Mybatis-Plus 分页排序查询
     */
    @Test
    public void testQueryByPageAndSort() {
        initData();
        int count = userService.count(new QueryWrapper<>());
        Page<User> userPage = new Page<>(1, 5);
        userPage.setDesc("id");
        IPage<User> page = userService.page(userPage, new QueryWrapper<>());
        Assert.assertEquals(5, page.getSize());
        Assert.assertEquals(count, page.getTotal());
        log.debug("【page.getRecords()】= {}", page.getRecords());
    }

    /**
     * 测试Mybatis-Plus 自定义查询
     */
    @Test
    public void testQueryByCondition() {
        initData();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "Save1").or().eq("phone_number", "17300000001").orderByDesc("id");
        int count = userService.count(wrapper);
        Page<User> userPage = new Page<>(1, 3);
        IPage<User> page = userService.page(userPage, wrapper);
        Assert.assertEquals(3, page.getSize());
        Assert.assertEquals(count, page.getTotal());
        log.debug("【page.getRecords()】= {}", page.getRecords());
    }

    /**
     * 初始化数据
     */
    private void initData() {
        testSaveList();
    }

}
```

## 2021-02-14新增

### ActiveRecord 模式

- Role.java

```java
package com.nateshao.orm.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @date Created by 邵桐杰 on 2021/6/30 23:50
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
@TableName("orm_role")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends Model<Role> {
    /**
     * 主键
     */
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 主键值，ActiveRecord 模式这个必须有，否则 xxById 的方法都将失效！
     * 即使使用 ActiveRecord 不会用到 RoleMapper，RoleMapper 这个接口也必须创建
     */
    @Override
    protected Serializable pkVal() {

        return this.id;
    }
}

```

- RoleMapper.java

```java
/**
 * <p>
 * RoleMapper
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-09-16 14:06
 */
public interface RoleMapper extends BaseMapper<Role> {
}
```

- ActiveRecordTest.java

```java
/**
 * <p>
 * Role
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-09-16 14:19
 */
@Slf4j
public class ActiveRecordTest extends SpringBootDemoOrmMybatisPlusApplicationTests {
    /**
     * 测试 ActiveRecord 插入数据
     */
    @Test
    public void testActiveRecordInsert() {
        Role role = new Role();
        role.setName("VIP");
        Assert.assertTrue(role.insert());
        // 成功直接拿会写的 ID
        log.debug("【role】= {}", role);
    }

    /**
     * 测试 ActiveRecord 更新数据
     */
    @Test
    public void testActiveRecordUpdate() {
        Assert.assertTrue(new Role().setId(1L).setName("管理员-1").updateById());
        Assert.assertTrue(new Role().update(new UpdateWrapper<Role>().lambda().set(Role::getName, "普通用户-1").eq(Role::getId, 2)));
    }

    /**
     * 测试 ActiveRecord 查询数据
     */
    @Test
    public void testActiveRecordSelect() {
        Assert.assertEquals("管理员", new Role().setId(1L).selectById().getName());
        Role role = new Role().selectOne(new QueryWrapper<Role>().lambda().eq(Role::getId, 2));
        Assert.assertEquals("普通用户", role.getName());
        List<Role> roles = new Role().selectAll();
        Assert.assertTrue(roles.size() > 0);
        log.debug("【roles】= {}", roles);
    }

    /**
     * 测试 ActiveRecord 删除数据
     */
    @Test
    public void testActiveRecordDelete() {
        Assert.assertTrue(new Role().setId(1L).deleteById());
        Assert.assertTrue(new Role().delete(new QueryWrapper<Role>().lambda().eq(Role::getName, "普通用户")));
    }
}
```

## 参考

- mybatis-plus官方文档：http://mp.baomidou.com/

