package com.nateshao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}














