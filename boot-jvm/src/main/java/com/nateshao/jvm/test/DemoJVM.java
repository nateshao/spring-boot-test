package com.nateshao.jvm.test;

/**
 * @date Created by 邵桐杰 on 2021/7/13 22:21
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class DemoJVM {
    public static void main(String[] args) {
        String nateshao = System.getProperty("nateshao");
        if (nateshao == null) {
            System.out.println("是千羽哦");
        }else {
            System.out.println(nateshao);

        }
    }

}
