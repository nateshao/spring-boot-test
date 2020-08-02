package com.nateshao.config;

import com.nateshao.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date Created by 邵桐杰 on 2020/8/1 11:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Slf4j
@ControllerAdvice
public class GlobaleExceptionHander {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R execpetion(Exception e) {
        return R.fail(e.getLocalizedMessage(), null);
    }
}
