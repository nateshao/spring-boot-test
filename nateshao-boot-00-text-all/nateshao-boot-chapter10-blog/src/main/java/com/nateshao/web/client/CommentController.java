package com.nateshao.web.client;

import com.nateshao.model.ResponseData.ArticleResponseData;
import com.nateshao.service.ICommentService;
import com.nateshao.utils.MyUtils;
import com.vdurmont.emoji.EmojiParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @date Created by 邵桐杰 on 2020/11/10 10:29
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Controller
@RequestMapping("/comments")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private ICommentService commentServcieImpl;

    // 发表评论操作
    @PostMapping(value = "/publish")
    @ResponseBody
    public ArticleResponseData publishComment(HttpServletRequest request, @RequestParam Integer aid, @RequestParam String text) {
        // 去除js脚本
        text = MyUtils.cleanXSS(text);
        text = EmojiParser.parseToAliases(text);
        // 获取当前登录用户
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 封装评论信息
        Comment comments = new Comment();
        comments.setArticleId(aid);
        comments.setIp(request.getRemoteAddr());
        comments.setCreated(new Date());
        comments.setAuthor(user.getUsername());
        comments.setContent(text);
        try {
            commentServcieImpl.pushComment(comments);
            logger.info("发布评论成功，对应文章id: "+aid);
            return ArticleResponseData.ok();
        } catch (Exception e) {
            logger.error("发布评论失败，对应文章id: "+aid +";错误描述: "+e.getMessage());
            return ArticleResponseData.fail();
        }
    }
}
