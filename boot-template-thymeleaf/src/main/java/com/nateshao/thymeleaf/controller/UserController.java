package com.nateshao.thymeleaf.controller;

import com.nateshao.thymeleaf.service.UserService;
import com.nateshao.thymeleaf.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/30 16:00
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String showUser(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "index";
    }

    // 进入添加界面
    @RequestMapping("/intoAdd")
    public String intoAdd(){
        return "add";
    }

    // 添加用户
    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/index";
    }

    // 删除用户
    @RequestMapping("/delete")
    public String delete(int id){
        userService.delete(id);
        return "redirect:/";
    }

    // 进入修改用户
    @RequestMapping("/intoUpdate")
    public String intoUpdate(Model model, int id){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "update";
    }

    // 修改用户
    @RequestMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/index";
    }

}