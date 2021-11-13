package com.nateshao.swagger.service;

import com.nateshao.swagger.domain.Student;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/11/13 10:06
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface StudentService {

    public List<Student> selectList();

    public Student queryStudentsById(String id);

    int add(Student student);

    int edit(Student student);

    int del(String id);

    Student getInfo(String id);
}
