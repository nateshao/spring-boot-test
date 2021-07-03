package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {

    public void save(User user);

    public User findById(int id);

    public List<User> findAll();

}
