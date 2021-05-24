package com.nateshao.layui.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @date Created by 邵桐杰 on 2021/5/24 22:06
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@SpringBootTest
class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    void test(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",655);
        System.out.println(mapper.selectOne(wrapper));
        System.out.println(mapper.selectOne(wrapper));// .sout 按Tab键补全
    }

}