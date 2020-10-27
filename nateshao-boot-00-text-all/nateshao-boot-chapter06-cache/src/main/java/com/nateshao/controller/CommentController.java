package com.nateshao.controller;

import com.nateshao.domain.Comment;
import com.nateshao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date Created by 邵桐杰 on 2020/10/27 12:14
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/get/{id}")
    public Comment findById(@PathVariable("id") int comment_id){
        Comment comment = commentService.findById(comment_id);
        return comment;
    }

    @GetMapping("/update/{id}/{author}")
    public Comment updateComment(@PathVariable("id") int comment_id,@PathVariable("author") String author){
        Comment comment = commentService.findById(comment_id);
        comment.setAuthor(author);
        Comment updateComment = commentService.updateComment(comment);
        return updateComment;
    }

    @GetMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id")int comment_id){
        commentService.deleteComment(comment_id);
    }

}



























