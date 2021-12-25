package com.nateshao.freemarker.service;


import com.nateshao.freemarker.mapper.StudentMapper;
import com.nateshao.freemarker.vo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/24 21:24
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public Student findById(Integer stuNo) {
        return studentMapper.findBystuNo(stuNo);
    }

    @Override
    public int del(Integer stuNo) {
        int count = studentMapper.del(stuNo);
        return count;
    }

    @Override
    public int updateStudent(Student student) {
        int count = studentMapper.updateStudent(student);
        return count;
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }
}
