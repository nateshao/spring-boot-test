package com.nateshao.layui.service;

import com.nateshao.layui.vo.BarVO;
import com.nateshao.layui.vo.DataVO;
import com.nateshao.layui.vo.PieVO;
import com.nateshao.layui.vo.ProductVO;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/5/24 22:19
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */

public interface ProductService {
    public DataVO<ProductVO> findData(Integer page,Integer limit);
    public BarVO getBarVO();
    public List<PieVO> getPieVO();
}

