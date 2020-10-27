package com.nateshao.repository;

import com.nateshao.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @date Created by 邵桐杰 on 2020/10/27 12:01
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE t_comment c set c.author = ? 1 where c.id = ?2")
    public int updateComment(String author,Integer id);

}
