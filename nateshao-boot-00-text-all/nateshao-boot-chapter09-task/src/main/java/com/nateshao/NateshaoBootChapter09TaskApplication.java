package com.nateshao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class NateshaoBootChapter09TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(NateshaoBootChapter09TaskApplication.class, args);
    }

}
