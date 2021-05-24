package com.nateshao.layui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nateshao.layui.entity.Product;
import com.nateshao.layui.entity.ProductCategory;
import com.nateshao.layui.mapper.ProductCategoryMapper;
import com.nateshao.layui.mapper.ProductMapper;
import com.nateshao.layui.service.ProductService;
import com.nateshao.layui.vo.DataVO;
import com.nateshao.layui.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2021/5/24 22:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public DataVO<ProductVO> findData() {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(mapper.selectCount(null));

        List<Product> productList = mapper.selectList(null);
        List<ProductVO> productVOlist = new ArrayList<>();
        for (Product product : productList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product,productVO);
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveloneId());
            ProductCategory productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null){
            productVO.setCategorylevelone(productCategory.getName());

            }


            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveltwoId());
            productVO.setCategoryleveltwo(productCategoryMapper.selectOne(wrapper).getName());
            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategorylevelthreeId());
            productVO.setCategorylevelthree(productCategoryMapper.selectOne(wrapper).getName());
            productVOlist.add(productVO);
        }
        dataVO.setData(productVOlist);


        return dataVO;
    }
}
