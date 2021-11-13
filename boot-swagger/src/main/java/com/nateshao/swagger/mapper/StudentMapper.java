package com.nateshao.swagger.mapper;

import com.nateshao.swagger.domain.Student;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/11/13 10:14
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Mapper
public interface StudentMapper {
    /**
     * 查询所有
     */
    public List<Student> selectAll();

    public Student queryStudentsById(String stuNo);

    int addStudent(Student student);
    /**
     * 根据主键修改
     * 空值也会覆盖掉数据库的值
     */
    int updateByPrimaryKey(Student student);

    int deleteByPrimaryKey(String stuNo);

    Student selectByPrimaryKey(String stuNo);
}
