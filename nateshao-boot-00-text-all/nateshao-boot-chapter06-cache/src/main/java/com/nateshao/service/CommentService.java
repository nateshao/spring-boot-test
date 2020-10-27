package com.nateshao.service;

import com.nateshao.domain.Comment;
import com.nateshao.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @date Created by 邵桐杰 on 2020/10/27 12:05
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public Comment findById(int comment_id){
        Optional<Comment> optional = commentRepository.findById(comment_id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @CachePut(cacheNames = "comment",key = "#result.id")
    public Comment updateComment(Comment comment){
        commentRepository.updateComment(comment.getAuthor(),comment.getaId());
        return comment;
    }

    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id){
        commentRepository.deleteById(comment_id);
    }
}



