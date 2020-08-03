

# nateshao-boot-14-mybatis

> �� demo ��ʾ�� Spring Boot �����ԭ���� mybatis ���ϣ�ʹ���� mybatis �ٷ��ṩ�Ľ��ּ� `mybatis-spring-boot-starter `���Ժ����׵ĺ� Spring Boot ���ϡ�

- ����`EasyCode`���д����Զ����ɡ�

  ![�������](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/���.png)

  ![�������ݿ�](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/�������ݿ�.png)

  ![�Զ�����](https://nateshao-blog.oss-cn-shenzhen.aliyuncs.com/img/�Զ�����.png)

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
    <artifactId>nateshao-boot-14-mybatis</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nateshao-boot-14-mybatis</name>
    <description>nateshao-boot-14-mybatis</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.3</version>
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
        <dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>persistence-api</artifactId>
            <version>2.2</version>
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

## NateshaoBoot14MybatisApplication.java

```java
package com.nateshao.nateshaoboot14mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NateshaoBoot14MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(NateshaoBoot14MybatisApplication.class, args);
    }

}
```

## application.yml

```yml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/user?serverTimezone=UTC
    driver-class-name: com.mysql.cj.jdbc.Driver


mybatis:
  # ָ�� mapper xml ���ļ���ַ
  mapper-locations: classpath:mapper/**.xml
  configuration:
    # �շ�����
    map-underscore-to-camel-case: true

    # ��ӡ��־
logging:
  level:
    com:
      nateshao:
        nateshaoboot14mybatis:
          mapper: debug
```

## UserService.java

```java
package com.nateshao.nateshaoboot14mybatis.service;

import com.nateshao.nateshaoboot14mybatis.entity.User;
import java.util.List;

/**
 * (User)�����ӿ�
 *
 * @author makejava
 * @since 2020-08-03 20:55:16
 */
public interface UserService {

    /**
     * ͨ��ID��ѯ��������
     *
     * @param id ����
     * @return ʵ������
     */
    User queryById(Integer id);

    /**
     * ��ѯ��������
     *
     * @param offset ��ѯ��ʼλ��
     * @param limit ��ѯ����
     * @return �����б�
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * ��������
     *
     * @param user ʵ������
     * @return ʵ������
     */
    User insert(User user);

    /**
     * �޸�����
     *
     * @param user ʵ������
     * @return ʵ������
     */
    User update(User user);

    /**
     * ͨ������ɾ������
     *
     * @param id ����
     * @return �Ƿ�ɹ�
     */
    boolean deleteById(Integer id);

}
```

## UserDao.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
      <mapper namespace="com.nateshao.nateshaoboot14mybatis.dao.UserDao">
      
          <resultMap id="BaseResultMap" type="com.nateshao.nateshaoboot14mybatis.entity.User">
              <!--@Table user-->
              <result property="id" column="id" jdbcType="INTEGER"/>
              <result property="username" column="username" jdbcType="VARCHAR"/>
              <result property="password" column="password" jdbcType="VARCHAR"/>
          </resultMap>
      
          <!--��ѯ����-->
          <select id="queryById" resultMap="BaseResultMap">
              select
                id, username, password
              from user.user
              where id = #{id}
          </select>
      
          <!--��ѯָ��������-->
          <select id="queryAllByLimit" resultMap="BaseResultMap">
              select
                id, username, password
              from user.user
              limit #{offset}, #{limit}
          </select>
      
          <!--ͨ��ʵ����Ϊɸѡ������ѯ-->
          <select id="queryAll" resultMap="BaseResultMap">
              select
                id, username, password
              from user.user
              <where>
                  <if test="id != null">
                      and id = #{id}
                  </if>
                  <if test="username != null and username != ''">
                      and username = #{username}
                  </if>
                  <if test="password != null and password != ''">
                      and password = #{password}
                  </if>
              </where>
          </select>
      
          <!--����������-->
          <insert id="insert" keyProperty="id" useGeneratedKeys="true">
              insert into user.user(username, password)
              values (#{username}, #{password})
          </insert>
      
          <!--ͨ�������޸�����-->
          <update id="update">
              update user.user
              <set>
                  <if test="username != null and username != ''">
                      username = #{username},
                  </if>
                  <if test="password != null and password != ''">
                      password = #{password},
                  </if>
              </set>
              where id = #{id}
          </update>
      
          <!--ͨ������ɾ��-->
          <delete id="deleteById">
              delete from user.user where id = #{id}
          </delete>
      
      </mapper>
```
## UserServiceImpl.java

```java
package com.nateshao.nateshaoboot14mybatis.service.impl;

import com.nateshao.nateshaoboot14mybatis.entity.User;
import com.nateshao.nateshaoboot14mybatis.dao.UserDao;
import com.nateshao.nateshaoboot14mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)�����ʵ����
 *
 * @author makejava
 * @since 2020-08-03 20:55:17
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * ͨ��ID��ѯ��������
     *
     * @param id ����
     * @return ʵ������
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * ��ѯ��������
     *
     * @param offset ��ѯ��ʼλ��
     * @param limit ��ѯ����
     * @return �����б�
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * ��������
     *
     * @param user ʵ������
     * @return ʵ������
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * �޸�����
     *
     * @param user ʵ������
     * @return ʵ������
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * ͨ������ɾ������
     *
     * @param id ����
     * @return �Ƿ�ɹ�
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }
}
```

## User.java

```java
package com.nateshao.nateshaoboot14mybatis.entity;

import java.io.Serializable;

/**
 * (User)ʵ����
 *
 * @author makejava
 * @since 2020-08-03 20:55:12
 */
public class User implements Serializable {
    private static final long serialVersionUID = -34261345919565106L;
    
    private Integer id;
    
    private String username;
    
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
```


## NateshaoBoot14MybatisApplicationTests.java

```java
package com.nateshao.nateshaoboot14mybatis;
       
       import com.nateshao.nateshaoboot14mybatis.dao.UserDao;
       import com.nateshao.nateshaoboot14mybatis.domain.SysUser;
       import com.nateshao.nateshaoboot14mybatis.entity.User;
       import com.nateshao.nateshaoboot14mybatis.mapper.SysUserMapper;
       import org.junit.jupiter.api.Test;
       import org.springframework.beans.factory.annotation.Autowired;
       import org.springframework.boot.test.context.SpringBootTest;
       
       import java.util.List;
       
       @SpringBootTest
       class NateshaoBoot14MybatisApplicationTests {
       
           @Autowired
           private SysUserMapper sysUserMapper;
       
           @Autowired
           private UserDao userDao;
           @Test
           void contextLoads() {
               System.out.println(sysUserMapper.selectAll());
           }
       
           @Test
           void insert() {
               SysUser user = new SysUser();
               user.setUsername("aaaaa");
               user.setPassword("aaaaaaaaa");
               System.out.println(sysUserMapper.saveSysUser(user));
               System.out.println();
       
           }
       
           @Test
           void selectUser(){
               List<User> users = userDao.queryAll(new User());
               System.out.println(users);
       
           }
       
       
       }
```

## �ο�

- Mybatis�ٷ��ĵ���http://www.mybatis.org/mybatis-3/zh/index.html

- Mybatis�ٷ����ּ��ĵ���http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

- Mybatis����Spring Boot�ٷ�demo��https://github.com/mybatis/spring-boot-starter/tree/master/mybatis-spring-boot-samples
