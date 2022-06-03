package com.xiaofei.hibernateDao;

import com.xiaofei.entity.Role;

import java.util.Set;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 20:11
 * Description:
 */
public interface RoleDao {
    Set<Role> getRolesByUserId(Long userId);
}
