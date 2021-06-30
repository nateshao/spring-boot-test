package com.demo.mapper;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/6/21 22:22
 * Description:
 */
@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
