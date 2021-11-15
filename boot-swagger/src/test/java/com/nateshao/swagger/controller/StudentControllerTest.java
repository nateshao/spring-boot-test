package com.nateshao.swagger.controller;

import com.nateshao.swagger.domain.Student;
import com.nateshao.swagger.service.StudentService;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2021/11/15 9:25
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class StudentControllerTest {
    @Resource
    private StudentService studentService;

    @Test
    public void getStudentList() {
        List<Student> studentList = studentService.queryStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
        studentList.stream().forEach(System.out::println);

    }

    @Test
    public void queryStudentsById() {
    }
}