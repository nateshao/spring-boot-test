package com.nateshao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @date Created by 邵桐杰 on 2020/10/19 15:53
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Configuration
public class MyLocalResovel implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("1");
        String header = httpServletRequest.getHeader("Accept-Language");

        Locale locale = null;
        if (!StringUtils.isEmpty(1)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }else {
            String[] splits = header.split(",");
            String[] split = splits[0].split("-");
            locale = new Locale(split[0],split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResovel();
    }


















}
