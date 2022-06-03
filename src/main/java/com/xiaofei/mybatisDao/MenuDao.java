package com.xiaofei.mybatisDao;

import com.xiaofei.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 20:14
 * Description:
 */
@Repository (value = "mybatisMenuDao")
public interface MenuDao {
    List<Menu> getMenuList();
    void updateMenu(Menu menu);
    void saveMenu(Menu menu);
    void deleteMenuById(Long id);
    Menu getMenuById(Long id);
}
