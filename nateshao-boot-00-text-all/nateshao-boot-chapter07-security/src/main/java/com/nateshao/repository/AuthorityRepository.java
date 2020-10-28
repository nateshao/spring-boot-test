package com.nateshao.repository;

import com.nateshao.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @date Created by 邵桐杰 on 2020/10/28 22:40
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 */
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    @Query(value = "select a.* from t_customer c,t_authority a,t_customer_authority ca where ca.customer_id=c.id and ca.authority_id=a.id and c.username =?1",nativeQuery = true)
    public List<Authority> findAuthoritiesByUsername(String username);

}
