package com.xiaofei.mybatisDao;

import com.xiaofei.entity.Link;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 16:02
 * Description:
 */
@Repository("mybatisLinkDao")
public interface LinkDao {
    List<Link> linkListPage(Map<String, Object> map);  
    void saveLink(Link link);
    void updateLink(Link link);
    void deleteLinkById(Long id);
    Link getLinkById(Long id);
    List<Link> getLinkList();
}
