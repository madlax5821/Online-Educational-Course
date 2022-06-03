package com.xiaofei.mybatisDao;

import com.xiaofei.entity.FootMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 21:21
 * Description:
 */
@Repository ("mybatisFootMenuDao")
public interface FootMenuDao {
    List<FootMenu> getAllFootMenus();
    void updateFootMenu(FootMenu footMenu);
    void saveFootMenu(FootMenu footMenu);
    void deleteFootMenuById(Long id);
    FootMenu getFootMenuById(Long id);
}
