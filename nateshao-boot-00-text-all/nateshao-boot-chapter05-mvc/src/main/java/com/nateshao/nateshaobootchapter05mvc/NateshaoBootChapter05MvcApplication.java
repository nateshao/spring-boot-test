package com.nateshao.nateshaobootchapter05mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
public class NateshaoBootChapter05MvcApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NateshaoBootChapter05MvcApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(NateshaoBootChapter05MvcApplication.class, args);
    }

}
