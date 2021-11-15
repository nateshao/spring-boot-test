package com.nateshao.swagger.mapper;

import com.nateshao.swagger.domain.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2021/11/14 23:00
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectAll() {
        List<Student> studentList = studentMapper.queryStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void queryStudentsById() {
        Student student = studentMapper.queryStudentsById(1111);
        System.out.println(student);

    }

    @Test
    public void addStudent() {


    }

    @Test
    public void updateByPrimaryKey() {
    }

//    @Test
//    public void deleteByPrimaryKey() {
//        int i = studentMapper.deleteByPrimaryKey(1);
//        System.out.println("成功删除" + i + "条记录");
//    }
}