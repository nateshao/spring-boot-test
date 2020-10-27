package com.nateshao.service;

import com.nateshao.domain.Comment;
import com.nateshao.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @date Created by 邵桐杰 on 2020/10/27 20:37
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Service
public class ApiCommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    public Comment findById(int comment_id){
        Object object = redisTemplate.opsForValue().get("comment_" + comment_id);
        if (object != null){
            return (Comment) object;
        }else {
            // 缓存没有，就查询数据库
            Optional<Comment> optional = commentRepository.findById(comment_id);
            if (optional.isPresent()){
                Comment comment = optional.get();
                redisTemplate.opsForValue().set("comment_"+comment_id,comment,1, TimeUnit.DAYS);
                return comment;
            }else {
                return null;
            }
        }

    }

    public Comment updateComment(Comment comment){

        commentRepository.updateComment(comment.getAuthor(), comment.getaId());

        return comment;
    }
    public void deleteComment(int comment_id){
        commentRepository.deleteById(comment_id);
        redisTemplate.delete("comment_"+comment_id);
    }


}
