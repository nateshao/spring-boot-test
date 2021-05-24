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
 */
public class Statistic {
    private Integer id;
    private Integer articleId;   // 评论的文章id
    private Integer hits;        // 点击量
    private Integer commentsNum;// 评论总量

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", hits=" + hits +
                ", commentsNum=" + commentsNum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }
}
