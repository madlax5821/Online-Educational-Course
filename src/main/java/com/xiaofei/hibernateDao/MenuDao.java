package com.xiaofei.hibernateDao;

import com.xiaofei.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 20:21
 * Description:
 */
public interface MenuDao {
    List<Menu> getMenuList();
}
