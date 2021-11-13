package com.nateshao.swagger.controller;

import com.nateshao.swagger.service.StudentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date Created by 邵桐杰 on 2021/11/13 10:02
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/student")
@Api(tags = "StudentController", description = "学生管理相关", value = "学生管理")
public class StudentController {
    @Autowired
    private StudentService studentService;


}
