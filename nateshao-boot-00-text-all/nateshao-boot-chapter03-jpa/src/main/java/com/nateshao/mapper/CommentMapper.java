package com.nateshao.mapper;

import com.nateshao.domain.Comment;
import org.apache.ibatis.annotations.*;

/**
 * @date Created by 邵桐杰 on 2020/9/14 21:24
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Mapper
public interface CommentMapper {

    @Select("select * from t_comment where id = #{id}")
    public Comment findById(Integer id);

    @Insert("INSERT INTO t_comment(content,author,a_id) " +
            "values (#{content},#{author},#{aId})")
    public int insertComment(Comment comment);

    @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
    public int updateComment(Comment comment);

    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    public int deleteComment(Integer id);

}
