package com.nateshao.rbac.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ShaoTongJie
 * @date 2021/8/5 10:03
 * 启动器
 */

@SpringBootApplication
@MapperScan("com.nateshao.rbac.shiro.mapper")
public class ShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class,args);
    }
}
