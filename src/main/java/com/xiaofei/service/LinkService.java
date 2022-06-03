package com.xiaofei.service;

import com.xiaofei.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-22, 13:41
 * Description:
 */
public interface LinkService {
    List<Link> linkListPage(Map<String, Object> map);
    void saveLink(Link link);
    void updateLink(Link link);
    void deleteLinkById(Long id);
    Link getLinkById(Long id);
    List<Link> getLinkList();
}
