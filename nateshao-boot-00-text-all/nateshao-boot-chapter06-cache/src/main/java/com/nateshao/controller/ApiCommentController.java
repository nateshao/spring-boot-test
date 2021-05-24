package com.nateshao.controller;

import com.nateshao.domain.Comment;
import com.nateshao.service.ApiCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date Created by 邵桐杰 on 2020/10/27 20:48
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@RestController
@RequestMapping("api")
public class ApiCommentController {
    @Autowired
    private ApiCommentService apiCommentService;

    @GetMapping("/get/{id}")
    public Comment findById(@PathVariable("id") int comment_id) {
        Comment comment = apiCommentService.findById(comment_id);
        return comment;
    }


    @GetMapping("/update/{id}")
    public Comment updateComment(@PathVariable("id") int comment_id, @PathVariable("author") String author) {
        Comment comment = apiCommentService.findById(comment_id);
        comment.setAuthor(author);
        Comment updateComment = apiCommentService.updateComment(comment);
        return updateComment;
    }

    @GetMapping("/delete/{id}")
    public void dateleteComment(@PathVariable("id") int comment_id) {
        apiCommentService.deleteComment(comment_id);
    }
}
