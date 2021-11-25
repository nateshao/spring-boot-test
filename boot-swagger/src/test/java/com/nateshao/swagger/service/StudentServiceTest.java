package com.nateshao.swagger.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.nateshao.swagger.mapper.StudentMapper;
import com.nateshao.swagger.utils.HttpUtils;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;
import java.util.Map;


/**
 * @date Created by 邵桐杰 on 2021/11/16 16:06
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void queryStudent() {
    }

    @Test
    public void queryStudentsById() {
    }

    @Test
    public void addStudent() {
    }

    @Test
    public void editstudentByStuNo() {
    }

    @Test
    public void delStudentByStuNo() {
    }
}