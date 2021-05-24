package com.nateshao.layui;

import com.nateshao.layui.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LayuiApplicationTests {
    @Autowired
    private ProductMapper mapper;

    @Test
    void contextLoads() {
    }
    @Test
    void test(){
        mapper.selectList(null).forEach(System.out::println);
    }

}
