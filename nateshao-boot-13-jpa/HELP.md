# spring-boot-demo-orm-jpa

> 此 demo 主要演示了 Spring Boot 如何使用 JPA 操作数据库，包含简单使用以及级联使用。



## 主要代码

### pom.xml

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
    <artifactId>nateshao-boot-13-jpa</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nateshao-boot-13-jpa</name>
    <description>nateshao-boot-13-jpa</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
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

###  JpaConfig.java

```java
/**
 * <p>
 * JPA配置类
 * </p>
 *
 * @package: com.xkcoding.orm.jpa.config
 * @description: JPA配置类
 * @author: yangkai.shen
 * @date: Created in 2018/11/7 11:05
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.xkcoding.orm.jpa.repository", transactionManagerRef = "jpaTransactionManager")
public class JpaConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter japVendor = new HibernateJpaVendorAdapter();
        japVendor.setGenerateDdl(false);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(japVendor);
        entityManagerFactory.setPackagesToScan("com.xkcoding.orm.jpa.entity");
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
```

###  SysUserDao.java

```java
package com.nateshao.nateshaoboot13jpa.dao;

import com.nateshao.nateshaoboot13jpa.domain.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @date Created by 邵桐杰 on 2020/8/2 21:30
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Repository
public interface SysUserDao extends CrudRepository<SysUser, Integer> {

    public SysUser findByUsername(String username);
}
```

### Department.java

```java
package com.nateshao.nateshaoboot13jpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @date Created by 邵桐杰 on 2020/8/2 21:30
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Entity
@Data
@Table(name = "user")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;
}
```

### application.yml

```yaml

spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/user?serverTimezone=UTC
    driver-class-name: com.mysql.cj.jdbc.Driver

```
### NateshaoBoot13JpaApplicationTests.java

```java
package com.nateshao.nateshaoboot13jpa;

import com.nateshao.nateshaoboot13jpa.dao.SysUserDao;
import com.nateshao.nateshaoboot13jpa.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class NateshaoBoot13JpaApplicationTests {


    @Autowired
    private SysUserDao userDao;

    @Test
    void contextLoads() {
        SysUser user = new SysUser();
        user.setUsername("lengleng");
        user.setPassword("paaaxc");

        userDao.save(user);

    }
    @Test
    void delete(){
        SysUser user1 = new SysUser();
        user1.setId(8);
        userDao.delete(user1);
    }
    @Test
    void  testUpd(){
        Optional<SysUser> optional = userDao.findById(4);
        SysUser sysUser = optional.get();

        sysUser.setPassword("newpwd");
        userDao.save(sysUser);
    }
    @Test
    void testQuery(){
//        Iterable<SysUser> all = userDao.findAll();
//        System.out.println(all);

        SysUser byUsername = userDao.findByUsername("1231");

        System.out.println(byUsername);
    }
}
```


### 其余代码及 SQL 参见本 demo

## 参考

- Spring Data JPA 官方文档：https://docs.spring.io/spring-data/jpa/docs/current/reference/html/ 