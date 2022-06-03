package com.xiaofei.service.impl;

import com.xiaofei.entity.Property;
import com.xiaofei.mybatisDao.PropertyDao;
import com.xiaofei.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 22:35
 * Description:
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    @Qualifier ("mybatisPropertyDao")
    private PropertyDao propertyDao;
    
    @Override
    public List<Property> getPropertyList() {
        return propertyDao.getPropertyList();
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyDao.getPropertyById(id);
    }

    @Override
    public void updateProperty(Property property) {
        propertyDao.updateProperty(property);
    }
}
