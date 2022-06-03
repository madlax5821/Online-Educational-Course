package com.xiaofei.service;

import com.xiaofei.entity.FootMenu;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 21:26
 * Description:
 */
public interface FootMenuService {
    List<FootMenu> getAllFootMenus();
    void updateFootMenu(FootMenu footMenu);
    void saveFootMenu(FootMenu footMenu);
    void deleteFootMenuById(Long id);
    FootMenu getFootMenuById(Long id);
}
