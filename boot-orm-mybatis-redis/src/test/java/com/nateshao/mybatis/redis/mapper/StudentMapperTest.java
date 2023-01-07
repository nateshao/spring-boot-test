//package com.nateshao.mybatis.redis.mapper;
//
//import com.nateshao.mybatis.redis.vo.Student;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * @date Created by 邵桐杰 on 2021/12/24 23:03
// * @微信公众号 千羽的编程时光
// * @个人网站 www.nateshao.cn
// * @博客 https://nateshao.gitee.io
// * @GitHub https://github.com/nateshao
// * @Gitee https://gitee.com/nateshao
// * Description:
// */
//@SpringBootTest
//public class StudentMapperTest {
//
//    @Autowired
//    private StudentMapper studentMapper;
//
//    @Test
//    public void findAllTest() {
//        List<Student> all = studentMapper.findAll();
//        all.stream().forEach(list-> System.out.println(list));
////        all.forEach(list-> System.out.println(list));
//    }
//
//    @Test
//    public void findBystuNo() {
//        Student bystuNo = studentMapper.findBystuNo(2021);
//        System.out.println("bystuNo = " + bystuNo);
//    }
//
//    @Test
//    public void del() {
//    }
//
//    @Test
//    public void updateStudent() {
//    }
//
//    @Test
//    public void add() {
//    }
//}