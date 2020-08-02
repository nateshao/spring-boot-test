package com.nateshao.nateshaoboot14mybatis;

import com.nateshao.nateshaoboot14mybatis.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NateshaoBoot14MybatisApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    void contextLoads() {
        System.out.println(sysUserMapper.selectAll());
    }

}
