package com.nateshao.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义 HealthIndicator
 *
 * @date Created by 邵桐杰 on 2020/7/21 22:41
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {

//    @Override
//    public Health getHealth(boolean includeDetails) {
//        return null;
//    }

    @Override
    public Health health() {
        // http 调用远程接口不通
        return Health.down().build();
    }
}
