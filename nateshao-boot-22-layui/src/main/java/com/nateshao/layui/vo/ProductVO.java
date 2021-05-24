package com.nateshao.layui.vo;

import lombok.Data;

/**
 * @date Created by 邵桐杰 on 2021/5/24 22:16
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
public class ProductVO {

    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer stock;
    private String categorylevelone;
    private String categoryleveltwo;
    private String categorylevelthree;
    private String fileName;

}
