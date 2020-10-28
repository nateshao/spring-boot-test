package com.nateshao.repository;

import com.nateshao.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @date Created by 邵桐杰 on 2020/10/28 22:40
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);
}
