package com.nateshao.nateshaoboot14mybatis.mapper;

import com.nateshao.nateshaoboot14mybatis.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/8/2 21:42
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
@Mapper
public interface SysUserMapper {
    List<SysUser> selectAll();

    Integer saveSysUser(@Param("user") SysUser user);
}
