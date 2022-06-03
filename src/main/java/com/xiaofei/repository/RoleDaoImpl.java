package com.xiaofei.repository;

import com.xiaofei.entity.Role;
import com.xiaofei.hibernateDao.RoleDao;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 20:14
 * Description:
 */
@Repository (value = "hibernateRoleDao")
public class RoleDaoImpl implements RoleDao {

    @Override
    public Set<Role> getRolesByUserId(Long userId) {
        return null;
    }
}
