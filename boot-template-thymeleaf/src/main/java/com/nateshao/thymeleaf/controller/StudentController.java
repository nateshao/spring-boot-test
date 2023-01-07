package com.nateshao.thymeleaf.controller;

import com.nateshao.thymeleaf.service.StudentService;
import com.nateshao.thymeleaf.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/24 18:14
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent")
    public String getStudent(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "studentIndex";
    }

}
