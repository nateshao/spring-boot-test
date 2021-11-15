package com.nateshao.swagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @date Created by 邵桐杰 on 2021/11/13 10:08
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生实体", description = "Student Entity")
public class Student implements Serializable {
    @ApiModelProperty("学生姓名")
    private String studName;
    @ApiModelProperty(value = "学号", required = true)
    private int stuNo;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("民族")
    private String nation;
    @ApiModelProperty("政治面貌")
    private String political;
    @ApiModelProperty("所在学校")
    private String school;
    @ApiModelProperty("主要工作")
    private String major;
    @ApiModelProperty("出生年月日")
    private Date birthday;
    @ApiModelProperty("入学时间")
    private Date entranceTime;

}