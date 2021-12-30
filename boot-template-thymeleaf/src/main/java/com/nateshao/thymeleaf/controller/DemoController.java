package com.nateshao.thymeleaf.controller;

import com.nateshao.thymeleaf.vo.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/30 15:12
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@RestController
public class DemoController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("k1", "v1");
        mv.addObject("user", new SysUser(1, "nateshao"));

        SysUser user = new SysUser(11, "nateshao11");
        SysUser user1 = new SysUser(11, "nateshao12");
        SysUser user2 = new SysUser(11, "nateshao13");
        SysUser user3 = new SysUser(11, "nateshao14");
        List<SysUser> arrayList = new ArrayList<>();
        arrayList.add(user);
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        mv.addObject("arrayList", arrayList);
        mv.setViewName("index");
        return mv;
    }
}
