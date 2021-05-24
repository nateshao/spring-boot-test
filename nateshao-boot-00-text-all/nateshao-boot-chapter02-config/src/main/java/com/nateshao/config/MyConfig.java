package com.nateshao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date Created by 邵桐杰 on 2020/9/13 23:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Configuration   // 定义该类是一个配置类
public class MyConfig {
    @Bean        // 将返回值对象作为组件添加到Spring容器中，该组件id默认为方法名
    public MyService myService() {
        return new MyService();
    }
}

