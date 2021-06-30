package com.demo.controller;

import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/6/21 22:21
 * Description:
 */
@Controller
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/query")
    @ResponseBody
    public List<User> query(){
        List<User> users = userMapper.queryUserList();
        return users;
    }
}
