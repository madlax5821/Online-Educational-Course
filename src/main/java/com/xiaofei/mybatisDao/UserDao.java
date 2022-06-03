package com.xiaofei.mybatisDao;

import com.xiaofei.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 20:07
 * Description:
 */
@Repository ("mybatisUserDao")
public interface UserDao {
    User getUserByUsername(String username);
}
