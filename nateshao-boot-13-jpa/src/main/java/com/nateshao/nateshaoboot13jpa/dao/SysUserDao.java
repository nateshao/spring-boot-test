package com.nateshao.nateshaoboot13jpa.dao;

import com.nateshao.nateshaoboot13jpa.domain.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lengleng
 * @date 2020/6/30
 */
@Repository
public interface SysUserDao extends CrudRepository<SysUser, Integer> {

    public SysUser findByUsername(String username);
}
