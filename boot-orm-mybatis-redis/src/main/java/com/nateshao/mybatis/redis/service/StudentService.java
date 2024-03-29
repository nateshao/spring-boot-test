package com.nateshao.mybatis.redis.service;

import com.nateshao.mybatis.redis.vo.Student;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/24 21:23
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface StudentService {

    List<Student> findAll();

    Student findById(Integer stuNo);

    int del(Integer stuNo);

    int updateStudent(Student student);

    int addStudent(Student student);
}
