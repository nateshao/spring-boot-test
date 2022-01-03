package com.nateshao.swagger.mapper;

import com.nateshao.swagger.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2021/11/13 10:14
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
//@Repository
@Mapper
public interface StudentMapper {
    /**
     * 查询所有
     */
    public List<Student> queryStudent();

    public Student queryStudentsById(Integer stuNo);

    int addStudent(Map<String, Object> map);

    int editstudentByStuNo(Student student);

    int delStudentByStuNo(int stuNo);

}
