package com.nateshao.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.management.snmp.jvminstr.JvmOSImpl;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @date Created by 邵桐杰 on 2020/10/27 22:11
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Controller
public class FileController {
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type")String type,@PathVariable("Path") String path){

        return "detail/"+type+"/"+path;
    }



    @GetMapping("/userLogin")
    public String toLoginPage(){
        return "login/login";
    }

    @GetMapping("getuserBySession")
    @ResponseBody
    public void getUser(HttpSession session) {
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            SecurityContextImpl attribute = (SecurityContextImpl) session.getAttribute(element);
            Authentication authentication = attribute.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            System.out.println(principal);
            System.out.println("username" + principal.getUsername());

        }
    }




        @GetMapping("/getuserByContext")
        @ResponseBody
        public void getUser2(){
            SecurityContext context = SecurityContextHolder.getContext();
            System.out.println("userDetails: "+context);

            // 获取用户的信息
            Authentication authentication=context.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            System.out.println(principal);
            System.out.println("username: "+principal.getUsername());


        }









}
















