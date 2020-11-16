package com.nateshao.service;

import com.github.pagehelper.PageInfo;
import com.nateshao.model.domain.Comment;

/**
 * @date Created by 邵桐杰 on 2020/11/16 8:40
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */

/*
    文章评论业务处理接口
 */

public interface ICommentService {
    // 获取文章下的评论
    public PageInfo<Comment> getComments(Integer aid, int page, int count);

    // 用户发表评论
    public void pushComment(Comment comment);
}
