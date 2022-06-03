package com.xiaofei.service;

import com.xiaofei.entity.Menu;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 20:18
 * Description:
 */
public interface MenuService {
    List<Menu> getMenuList();
    void updateMenu(Menu menu);
    void saveMenu(Menu menu);
    void deleteMenuById(Long id);
    Menu getMenuById(Long id);
}
