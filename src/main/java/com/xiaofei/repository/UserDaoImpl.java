package com.xiaofei.repository;

import com.xiaofei.entity.User;
import com.xiaofei.hibernateDao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 14:50
 * Description:
 */
@Repository (value = "hibernateUserDao")
public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
