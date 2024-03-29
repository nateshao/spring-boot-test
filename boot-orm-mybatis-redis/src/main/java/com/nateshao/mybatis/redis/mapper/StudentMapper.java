package com.nateshao.mybatis.redis.mapper;

import com.nateshao.mybatis.redis.vo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2021/12/24 18:15
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Mapper
public interface StudentMapper {
//    @Select("select * from student")
//    List<Student> findAll();
//
//    @Select("select * from student where stuNo=#{stuNo}")
//    Student findBystuNo(Integer stuNo);
//
//    @Delete("delete from student where stuNo=#{stuNo}")
//    int del(Integer stuNo);
//
////    @Update("update student set " +
////            "studName=#{studName},sex=#{sex},nation=#{nation},political=#{political},school=#{school},major=#{major},birthday=#{birthday},entranceTime=#{entranceTime} " +
////            "where stuNo=#{stuNo}")
////      int updateStudent(Student student);
//
////    @Update("update student set\n" +
////            "           studName = #{studName,jdbcType=CHAR}\n" +
////            "           sex = #{sex,jdbcType=CHAR}\n" +
////            "           nation = #{nation,jdbcType=VARCHAR}\n" +
////            "           political = #{political,jdbcType=VARCHAR}\n" +
////            "           school = #{school,jdbcType=VARCHAR}\n" +
////            "           major = #{major,jdbcType=VARCHAR}\n" +
////            "           birthday = #{birthday,jdbcType=DATE}\n" +
////            "           entranceTime = #{entranceTime,jdbcType=DATE}\n" +
////            "        \n" +
////            "    where stuNo = #{stuNo,jdbcType=INTEGER}")
//    int updateStudent(Student student);
//
////    @Insert("insert into student(studName,stuNo,sex,nation,political,school,major,birthday,entranceTime) " +
////            "values(#{studName},#{stuNo},#{sex},#{nation},#{political},#{school},#{major},#{birthday},#{entranceTime})")
//    int addStudent(Student student);
    /**
     * 查询所有
     */
    public List<Student> queryStudent();

    public Student queryStudentsById(Integer stuNo);

    int addStudent(Student student);

    int editstudentByStuNo(Student student);

    int delStudentByStuNo(int stuNo);



}



