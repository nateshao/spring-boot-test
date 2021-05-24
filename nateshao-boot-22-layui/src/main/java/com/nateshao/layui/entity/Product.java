package com.nateshao.layui.entity;

import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2021/5/24 21:26
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
public class Product {

    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer stock;
    private Integer categoryleveloneId;
    private Integer categoryleveltwoId;
    private Integer categorylevelthreeId;
    private String fileName;
}
