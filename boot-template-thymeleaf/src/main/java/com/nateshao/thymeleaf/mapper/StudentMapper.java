package com.nateshao.thymeleaf.mapper;
import com.nateshao.thymeleaf.vo.Student;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/12/24 18:15
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface StudentMapper {
    /**
     * 查询所有
     */
    public List<Student> queryStudent();

    public Student queryStudentsById(Integer stuNo);

    int addStudent(Student student);

    int editstudentByStuNo(Student student);

    int delStudentByStuNo(int stuNo);
}



