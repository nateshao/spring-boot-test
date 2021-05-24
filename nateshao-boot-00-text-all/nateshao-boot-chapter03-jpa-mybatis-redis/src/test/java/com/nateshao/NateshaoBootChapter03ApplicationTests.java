package com.nateshao;

import com.nateshao.domain.Article;
import com.nateshao.domain.Comment;
import com.nateshao.mapper.ArticleMapper;
import com.nateshao.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
class NateshaoBootChapter03ApplicationTests {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    @Transactional
    void contextLoads2() {
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }

    @Test
    @Transactional
    void contextLoads() {
        Comment comment = commentMapper.findById(1);
        System.out.println(comment);
    }


}
