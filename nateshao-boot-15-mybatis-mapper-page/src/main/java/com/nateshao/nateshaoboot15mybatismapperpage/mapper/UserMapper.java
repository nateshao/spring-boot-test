package com.nateshao.nateshaoboot15mybatismapperpage.mapper;

import com.nateshao.nateshaoboot15mybatismapperpage.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @date Created by 邵桐杰 on 2020/8/3 21:43
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
