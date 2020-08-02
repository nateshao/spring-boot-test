package com.nateshao;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2020/7/30 23:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Data
@AllArgsConstructor
public class R {


    private Integer code;
    private String msg;
    private Object data;


    public static R success(Object data) {
        return new R(1, null, data);
    }

    public static R fail(String msg, Object data) {
        return new R(-1, msg, data);
    }


}
