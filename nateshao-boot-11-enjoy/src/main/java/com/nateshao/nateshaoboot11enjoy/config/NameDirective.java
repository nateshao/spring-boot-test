package com.nateshao.nateshaoboot11enjoy.config;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import org.apache.tomcat.jni.Directory;

import java.io.IOException;

/**
 * @date Created by 邵桐杰 on 2020/8/2 14:08
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
public class NameDirective extends Directive {


    @Override
    public void exec(Env env, Scope scope, Writer writer) {
       try {
           writer.write("我是自定义指令");
       }catch (IOException e){
           e.printStackTrace();
       }
    }
}









