package com.nateshao.thymeleaf.controller;

import com.nateshao.thymeleaf.service.StudentService;
import com.nateshao.thymeleaf.vo.Student;
import com.nateshao.thymeleaf.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    // 进入添加界面
    @RequestMapping("/intoAddStudent")
    public String intoAdd(){
        return "addStudent";
    }
    // 添加用户
    @RequestMapping("/addStudent")
    public String add(Student student){
        studentService.addStudent(student);
        return "redirect:/studentIndex";
    }

    @GetMapping("/findById/{stuNo}")
    public String findById(Model model, @PathVariable("stuNo") Integer stuNo) {
        model.addAttribute("student", studentService.findById(stuNo));
        return "student";
    }

    @PostMapping("/addStudent")
    public int addStudent(Student student) {
        return studentService.addStudent(student);
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
