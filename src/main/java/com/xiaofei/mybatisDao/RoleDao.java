package com.xiaofei.mybatisDao;

import com.xiaofei.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 20:15
 * Description:
 */
@Repository ("mybatisRoleDao")
public interface RoleDao {
    Set<Role> getRolesByUserId(Long userId);
}
