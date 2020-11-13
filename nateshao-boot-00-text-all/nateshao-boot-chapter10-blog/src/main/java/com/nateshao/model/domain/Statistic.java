package com.nateshao.model.domain;

/**
 * @date Created by 邵桐杰 on 2020/11/10 9:58
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
/**
 * 文章相关动态数据统计实体类
 * */
public class Statistic {
    private Integer id;
    private Integer articleId;   // 评论的文章id
    private Integer hits;        // 点击量
    private Integer commentsNum;// 评论总量

}
