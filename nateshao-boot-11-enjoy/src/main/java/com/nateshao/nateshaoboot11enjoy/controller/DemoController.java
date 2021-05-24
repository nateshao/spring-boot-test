package com.nateshao.nateshaoboot11enjoy.controller;

import com.nateshao.nateshaoboot11enjoy.vo.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/8/2 12:48
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Controller
public class DemoController {

    @GetMapping
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("username", "nateshao");
        modelAndView.setViewName("index");
        SysUser sysUser = new SysUser(1, "nateshao1111");
        SysUser sysUser1 = new SysUser(1, "nateshao2222");
        SysUser sysUser2 = new SysUser(1, "nateshao3333");
        SysUser sysUser3 = new SysUser(1, "nateshao4444");

        List<SysUser> userList = new ArrayList<>();
        userList.add(sysUser);
        userList.add(sysUser1);
        userList.add(sysUser2);
        userList.add(sysUser3);

        modelAndView.addObject("userList", userList);
        modelAndView.addObject("date", new Date());

        return modelAndView;
    }
}












