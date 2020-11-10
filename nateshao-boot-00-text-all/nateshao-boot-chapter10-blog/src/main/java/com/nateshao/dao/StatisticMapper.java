package com.nateshao.dao;

import com.nateshao.model.domain.Article;
import com.nateshao.model.domain.Statistic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/11/10 10:07
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Mapper
public interface StatisticMapper {
    // 新增文章对应的统计信息
    @Insert("INSERT INTO t_statistic(article_id,hits,comments_num) values (#{id},0,0)")
    public void addStatistic(Article article);

    // 根据文章id查询点击量和评论量相关信息
    @Select("SELECT * FROM t_statistic WHERE article_id=#{articleId}")
    public Statistic selectStatisticWithArticleId(Integer articleId);

    // 通过文章id更新点击量
    @Update("UPDATE t_statistic SET hits=#{hits} " +
            "WHERE article_id=#{articleId}")
    public void updateArticleHitsWithId(Statistic statistic);

    // 通过文章id更新评论量
    @Update("UPDATE t_statistic SET comments_num=#{commentsNum} " +
            "WHERE article_id=#{articleId}")
    public void updateArticleCommentsWithId(Statistic statistic);

    // 根据文章id删除统计数据
    @Delete("DELETE FROM t_statistic WHERE article_id=#{aid}")
    public void deleteStatisticWithId(int aid);

    // 统计文章热度信息
    @Select("SELECT * FROM t_statistic WHERE hits !='0' " +
            "ORDER BY hits DESC, comments_num DESC")
    public List<Statistic> getStatistic();

    // 统计博客文章总访问量
    @Select("SELECT SUM(hits) FROM t_statistic")
    public long getTotalVisit();

    // 统计博客文章总评论量
    @Select("SELECT SUM(comments_num) FROM t_statistic")
    public long getTotalComment();
}
