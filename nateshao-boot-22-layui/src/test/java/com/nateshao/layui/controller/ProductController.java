package com.nateshao.layui.controller;

import com.nateshao.layui.service.ProductService;
import com.nateshao.layui.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date Created by 邵桐杰 on 2021/5/24 23:52
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public DataVO list(){
        return productService.findData();
    }

}
