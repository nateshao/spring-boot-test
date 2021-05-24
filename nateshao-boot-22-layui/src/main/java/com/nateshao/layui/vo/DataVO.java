package com.nateshao.layui.vo;

import lombok.Data;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/5/24 22:03
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */

@Data
public class DataVO<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;


}
