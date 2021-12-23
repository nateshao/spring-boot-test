package com.nateshao.redis.controller;

import com.nateshao.redis.pojo.User;
import com.nateshao.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @date Created by 邵桐杰 on 2021/12/23 13:54
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user) {
        logger.info("开始新增...");
        return userService.addUser(user);
    }
    @PutMapping("/updateUser")
    public boolean updateUser(@RequestBody User user) {
        logger.info("开始更新...");
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestParam(value = "id", required = true) int userId) {
        logger.info("开始删除...");
        return userService.deleteUser(userId);
    }


    @GetMapping("/getUserId")
    public User getUserId(@RequestParam(value = "id", required = true) int userId) {
        logger.info("开始查询所有数据...");
        return userService.getUserId(userId);
    }
}


































