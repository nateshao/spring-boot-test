package com.nateshao.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @date Created by 邵桐杰 on 2020/7/21 20:53
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 */
@Data
@Component
@ConfigurationProperties(prefix = "user")
public class DemoConfig {
    private String username;
    private String password;
    private Integer age;

}
