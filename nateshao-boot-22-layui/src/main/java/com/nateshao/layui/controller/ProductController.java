package com.nateshao.layui.controller;

import com.nateshao.layui.mapper.ProductCategoryMapper;
import com.nateshao.layui.mapper.ProductMapper;
import com.nateshao.layui.service.ProductService;
import com.nateshao.layui.vo.BarVO;
import com.nateshao.layui.vo.DataVO;
import com.nateshao.layui.vo.PieVO;
import com.nateshao.layui.vo.ProductBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/5/25 19:46
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(Integer page,Integer limit){
        return productService.findData(page, limit);
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/barVO")
    @ResponseBody
    public BarVO getBarVO(){
        return productService.getBarVO();
    }

//    @RequestMapping("/pieVO")
//    @ResponseBody
//    public List<PieVO> getPieVO(){
//        return productService.getPieVO();
//    }

    @RequestMapping("/pieVO")
    @ResponseBody
    public List<ProductBarVO> getPieVO(){
        return productMapper.findAllProductBarVO();
    }

}
