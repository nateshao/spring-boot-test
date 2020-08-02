package com.nateshao.controller;

import cn.hutool.core.util.ObjectUtil;
import com.nateshao.vo.SysUser;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/8/2 9:40
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */

@RestController
public class DemoController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("k1","v1");
        mv.addObject("user",new SysUser(1,"nateshao"));

        SysUser user = new SysUser(11,"nateshao11");
        SysUser user1 = new SysUser(11,"nateshao12");
        SysUser user2 = new SysUser(11,"nateshao13");
        SysUser user3 = new SysUser(11,"nateshao14");
        List<SysUser> arrayList = new ArrayList<>();
        arrayList.add(user);
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        mv.addObject("arrayList",arrayList);
        mv.setViewName("index");
        return mv;
    }
}
