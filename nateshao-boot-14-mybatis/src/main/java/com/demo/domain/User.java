package com.demo.domain;

import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2021/6/21 22:22
 * Description:
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
}
