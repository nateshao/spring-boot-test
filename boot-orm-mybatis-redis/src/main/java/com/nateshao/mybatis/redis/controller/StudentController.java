package com.nateshao.mybatis.redis.controller;

import com.nateshao.mybatis.redis.service.StudentService;
import com.nateshao.mybatis.redis.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/24 18:14
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public int addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/findAll")
    public List<Student> findAll() {
        return studentService.findAll();
    }

//    @GetMapping("/student")
//    public Student findById(Integer stuNo) {
//        return studentService.findBystuNo(stuNo);
//    }

    @GetMapping("/findById/{stuNo}")
    public Student findById(@PathVariable("stuNo") Integer stuNo) {
        return studentService.findById(stuNo);
    }

    @PutMapping("/updateStudent")
    public int updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/del/{stuNo}")
    public int del(@PathVariable("stuNo") Integer stuNo) {
        return studentService.del(stuNo);
    }


}
