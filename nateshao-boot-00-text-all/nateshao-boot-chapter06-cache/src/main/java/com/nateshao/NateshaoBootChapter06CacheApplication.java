package com.nateshao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching // 开启注解缓存
@SpringBootApplication
public class NateshaoBootChapter06CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(NateshaoBootChapter06CacheApplication.class, args);
    }

}
