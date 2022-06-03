package com.xiaofei.hibernateDao;

import com.xiaofei.entity.User;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 14:50
 * Description:
 */
public interface UserDao {
    User getUserByUsername(String username);
}
