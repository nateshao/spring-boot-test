package com.nateshao.mybatis.redis.service;

import com.nateshao.mybatis.redis.mapper.StudentMapper;
import com.nateshao.mybatis.redis.vo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/24 21:24
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<Student> findAll() {
        String key = "student";
        ListOperations<String, Student> operations = redisTemplate.opsForList();
        //缓存存在
        if (redisTemplate.hasKey(key)) {
            return operations.range(key, 0, -1);

        } else {
            //得到学生集合
            List<Student> list = studentMapper.findAll();
            operations.leftPushAll(key, list);
            return list;
        }
    }

    @Override
    public Student findById(Integer stuNo) {
        String key = "student_" + stuNo;
        ValueOperations<String, Student> operations = redisTemplate.opsForValue();
        //缓存存在
        if (redisTemplate.hasKey(key)) {
            Student student = operations.get(key);
            System.out.println("缓存有数据，直接获取缓存数据。学号为：" + student.getStuNo());
//            LOGGER.info("StudentServiceImpl.findById() : 从缓存中获取了用户 >> " + student.getStuNo());
            return student;
        } else {
            //得到学生对象
            Student student = studentMapper.findBystuNo(stuNo);
            //添加到缓存
            operations.set(key, student);
            System.out.println("缓存没数据，从数据库拿数据。学号为：" + student.getStuNo());
            return student;
        }
    }

    @Override
    public int del(Integer stuNo) {
        //删除数据库中的数据
        int count = studentMapper.del(stuNo);
        //缓存存在
        String key = "student_" + stuNo;
        if (redisTemplate.hasKey(key)) {
            //删除对应缓存
            redisTemplate.delete(key);
            LOGGER.info("UserServiceImpl.deleteUser():从缓存中删除了用户 >> " + stuNo);
        }
        return count;
    }

    @Override
    public int modify(Student student) {
        //修改数据库中的数据
        int count = studentMapper.modify(student);

        ValueOperations operations = redisTemplate.opsForValue();
        //缓存存在
        String key = "student_" + student.getStuNo();
        if (redisTemplate.hasKey(key)) {
            //更新缓存
            Student stu = studentMapper.findBystuNo(student.getStuNo());
            operations.set(key, stu);
        }
        return count;
    }

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }
}
