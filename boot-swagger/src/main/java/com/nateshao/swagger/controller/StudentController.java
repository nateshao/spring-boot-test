package com.nateshao.swagger.controller;

import com.nateshao.swagger.domain.Student;
import com.nateshao.swagger.model.AjaxResult;
import com.nateshao.swagger.service.StudentService;
import com.nateshao.swagger.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static com.nateshao.swagger.model.AjaxResult.toAjax;

/**
 * @date Created by 邵桐杰 on 2021/11/13 10:02
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/student")
@Api(tags = "StudentController", description = "学生管理相关", value = "学生管理")
public class StudentController {
    //    @Resource
    @Autowired
    private StudentService studentService;

    /**
     * 查询所有学生
     */
    @GetMapping("getStudentList")
    @ApiOperation("查询所有学生")
    public AjaxResult<List<Student>> getStudentList() {
        List<Student> studentList = studentService.queryStudent();
        return AjaxResult.success(studentList);
    }

    /**
     * 通过学号查询学生
     */
    @GetMapping("queryStudentsById")
    @ApiOperation("通过学号查询学生")
    public AjaxResult<Student> queryStudentsById(@RequestParam @NotBlank(message = "学号不能为空") Integer stuNo) {
        Student student = studentService.queryStudentsById(stuNo);
        return AjaxResult.success(student);
    }

    @PostMapping("addStudent")
    @ApiOperation("添加学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studName", value = "学生姓名"),
            @ApiImplicitParam(name = "stuNo", value = "学号"),
            @ApiImplicitParam(name = "sex", value = "性别"),
            @ApiImplicitParam(name = "nation", value = "民族"),
            @ApiImplicitParam(name = "political", value = "政治面貌"),
            @ApiImplicitParam(name = "school", value = "所在学校"),
            @ApiImplicitParam(name = "major", value = "主要工作"),
            @ApiImplicitParam(name = "birthday", value = "出生年月日 格式：xxxx-xx-xx"),
            @ApiImplicitParam(name = "entranceTime", value = "入学时间 格式：xxxx-xx-xx")
    })
    public AjaxResult addStudent(@RequestParam @NotBlank(message = "姓名不能为空") String studName,
                                 @RequestParam @NotBlank(message = "学号不能为空") Integer stuNo,
                                 @RequestParam(defaultValue = "男") String sex,
                                 @RequestParam(defaultValue = "汉") String nation,
                                 @RequestParam(defaultValue = "中共党员") String political,
                                 @RequestParam(defaultValue = "华南理工大学") String school,
                                 @RequestParam(defaultValue = "搬砖") String major,
                                 @RequestParam String birthday,
                                 @RequestParam String entranceTime
    ) {
        int i = studentService.addStudent(studName, stuNo, sex, nation, political, school, major, birthday, entranceTime);
        return AjaxResult.success("成功插入" + i + "记录" + "学号为：" + stuNo);
    }

    @PutMapping("editStudentByStuNo")
    @ApiOperation("根据学号修改学生信息")
//    @ApiImplicitParam(name = "stuNo", value = "学号")
    public AjaxResult editStudentByStuNo(@RequestBody @Validated Student student) {
//        if (StringUtils.isEmpty(stuNo) || !stuNo.equals(student.getStuNo())) {
//            return AjaxResult.message("学号不正确");
//        }
        studentService.editstudentByStuNo(student);
        return AjaxResult.success();
    }

    @DeleteMapping("/delStudentByStuNo")
    @ApiOperation(value = "通过学号删除学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学号", required = true)
    })
    public AjaxResult delStudentByStuNo(@RequestParam @NotBlank(message = "学号不能为空") int stuNo) {
        int i = studentService.delStudentByStuNo(stuNo);
        return toAjax(i);
    }


}
