package com.nateshao.service;

import com.nateshao.model.ResponseData.StaticticsBo;
import com.nateshao.model.domain.Article;
import com.nateshao.model.domain.Comment;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/11/16 8:41
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */

// 博客站点统计服务
public interface ISiteService {
    // 最新收到的评论
    public List<Comment> recentComments(int count);

    // 最新发表的文章
    public List<Article> recentArticles(int count);

    // 获取后台统计数据
    public StaticticsBo getStatistics();

    // 更新某个文章的统计数据
    public void updateStatistics(Article article);
}
