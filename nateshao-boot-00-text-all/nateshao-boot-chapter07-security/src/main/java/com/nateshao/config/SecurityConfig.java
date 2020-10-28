package com.nateshao.config;

import com.nateshao.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @date Created by 邵桐杰 on 2020/10/28 22:00
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    /******************* 自定义用户认证 ***********************/
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        auth.inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("shitou").password(encoder.encode("123456")).roles("common")
//                .and()
//                .withUser("李四").password(encoder.encode("123456")).roles("vip");
//
//
////        super.configure(auth);
//    }

    /******************* JDBC用户认证 ***********************/

//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        // 2、使用JDBC进行身份认证
//        String userSQL ="select username,password,valid from t_customer " +
//                "where username = ?";
//        String authoritySQL="select c.username,a.authority from t_customer c,t_authority a,"+
//                "t_customer_authority ca where ca.customer_id=c.id " +
//                "and ca.authority_id=a.id and c.username =?";
//        auth.jdbcAuthentication().passwordEncoder(encoder)
//                .dataSource(dataSource)
//                .usersByUsernameQuery(userSQL)
//                .authoritiesByUsernameQuery(authoritySQL);
//    }

    /******************* UserDetailsService进行身份认证 ***********************/


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 2、使用JDBC进行身份认证
        String userSQL ="select username,password,valid from t_customer " +
                "where username = ?";
        String authoritySQL="select c.username,a.authority from t_customer c,t_authority a,"+
                "t_customer_authority ca where ca.customer_id=c.id " +
                "and ca.authority_id=a.id and c.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(userSQL)
                .authoritiesByUsernameQuery(authoritySQL);


        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }


}


























