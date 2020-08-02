package com.nateshao.nateshaoboot12jdbctemplate.service;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @date Created by 邵桐杰 on 2020/8/2 17:31
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Service
@AllArgsConstructor
public class UserService {


    private final JdbcTemplate jdbcTemplate;

    public void insert(String username,String password){
        jdbcTemplate.update("insert into user(username,password) value (?,?)",username,password);
    }

    public void delete(Integer id){
        jdbcTemplate.update("delete from user where id=?",id);
    }

    public void update(String password,Integer id){
        jdbcTemplate.update("update user set password = ? where id = ?",password,id);
    }

    public void query(Integer id){
        jdbcTemplate.queryForMap("select * from user where id = ?",id);
    }


}
