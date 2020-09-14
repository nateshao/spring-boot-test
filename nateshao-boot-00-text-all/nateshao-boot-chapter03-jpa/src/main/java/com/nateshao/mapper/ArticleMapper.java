package com.nateshao.mapper;

import com.nateshao.domain.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @date Created by 邵桐杰 on 2020/9/14 21:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Mapper
public interface ArticleMapper {

    public Article selectArtcle();

    public int updateArticle(Article article);

}
