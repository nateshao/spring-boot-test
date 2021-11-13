package com.nateshao.swagger.service.impl;

import com.nateshao.swagger.domain.Student;
import com.nateshao.swagger.mapper.StudentMapper;
import com.nateshao.swagger.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/11/13 10:13
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService, Serializable {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectList() {
        return studentMapper.selectAll();
    }

    @Override
    public Student queryStudentsById(String stuNo) {
        return studentMapper.queryStudentsById(stuNo);
    }

    @Override
    public int add(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int edit(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public int del(String id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student getInfo(String id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
