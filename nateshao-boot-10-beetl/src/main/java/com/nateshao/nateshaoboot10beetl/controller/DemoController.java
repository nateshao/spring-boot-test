package com.nateshao.nateshaoboot10beetl.controller;

import com.nateshao.nateshaoboot10beetl.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/8/2 11:42
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

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.btl");

        User user = new User(1, "nateshaoaaaaaaaaaa");
        User user1 = new User(1, "nateshaobbbbbbbbbbb");
        User user2 = new User(1, "nateshaocccccccccccc");
        User user3 = new User(1, "nateshaoddddddddddd");
        List<User> arrayList = new ArrayList<>();
        arrayList.add(user);
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        mv.addObject("arrayList", arrayList);
        mv.addObject("date", new Date());
//        mv.addObject("username","nateshao");
        return mv;
    }
}
