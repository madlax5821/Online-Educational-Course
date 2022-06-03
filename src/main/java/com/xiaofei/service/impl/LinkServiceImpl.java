package com.xiaofei.service.impl;

import com.xiaofei.entity.Link;
import com.xiaofei.mybatisDao.LinkDao;
import com.xiaofei.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-22, 13:41
 * Description:
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    @Qualifier("mybatisLinkDao")
    private LinkDao linkDao;

    @Override
    public List<Link> linkListPage(Map<String, Object> map) {
        return linkDao.linkListPage(map);
    }

    @Override
    public void saveLink(Link link) {
        linkDao.saveLink(link);
    }

    @Override
    public void updateLink(Link link) {
        linkDao.updateLink(link);
    }

    @Override
    public void deleteLinkById(Long id) {
        linkDao.deleteLinkById(id);
    }

    @Override
    public Link getLinkById(Long id) {
        return linkDao.getLinkById(id);
    }

    @Override
    public List<Link> getLinkList() {
        return linkDao.getLinkList();
    }
}
