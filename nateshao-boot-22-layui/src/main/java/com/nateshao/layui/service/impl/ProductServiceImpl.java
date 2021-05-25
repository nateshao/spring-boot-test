package com.nateshao.layui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public DataVO<ProductVO> findData(Integer page,Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        // 分页拦截器
        IPage<Product> productIPage = new Page<>(page,limit);
        IPage<Product> result = mapper.selectPage(productIPage,null);
        dataVO.setCount(result.getTotal());

        List<Product> productList = result.getRecords();
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
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null){
                productVO.setCategoryleveltwo(productCategory.getName());
            }

            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategorylevelthreeId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null){
                productVO.setCategorylevelthree(productCategory.getName());
            }
            productVOlist.add(productVO);
        }
        dataVO.setData(productVOlist);


        return dataVO;
    }
}
