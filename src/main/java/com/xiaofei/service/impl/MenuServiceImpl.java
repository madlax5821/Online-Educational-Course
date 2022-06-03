package com.xiaofei.service.impl;

import com.xiaofei.entity.Menu;
import com.xiaofei.mybatisDao.MenuDao;
import com.xiaofei.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 20:19
 * Description:
 */
@Service
public class MenuServiceImpl implements MenuService {
    
    @Autowired
    @Qualifier ("mybatisMenuDao")
    private MenuDao menuDao;
    
    @Override
    public List<Menu> getMenuList() {
        return menuDao.getMenuList();
    }

    @Override
    public void updateMenu(Menu menu) {
        menuDao.updateMenu(menu);
    }

    @Override
    public void saveMenu(Menu menu) {
        menuDao.saveMenu(menu);
    }

    @Override
    public void deleteMenuById(Long id) {
        menuDao.deleteMenuById(id);
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuDao.getMenuById(id);
    }
}
