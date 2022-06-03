package com.xiaofei.service.impl;

import com.xiaofei.entity.FootMenu;
import com.xiaofei.mybatisDao.FootMenuDao;
import com.xiaofei.service.FootMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 21:26
 * Description:
 */
@Service
public class FootMenuServiceImpl implements FootMenuService {

    @Autowired
    private FootMenuDao footMenuDao;
    
    @Override
    public List<FootMenu> getAllFootMenus() {
        return footMenuDao.getAllFootMenus();
    }

    @Override
    public void updateFootMenu(FootMenu footMenu) {
        footMenuDao.updateFootMenu(footMenu);
    }

    @Override
    public void saveFootMenu(FootMenu footMenu) {
        footMenuDao.saveFootMenu(footMenu);
    }

    @Override
    public void deleteFootMenuById(Long id) {
        footMenuDao.deleteFootMenuById(id);
    }

    @Override
    public FootMenu getFootMenuById(Long id) {
        return footMenuDao.getFootMenuById(id);
    }
}
