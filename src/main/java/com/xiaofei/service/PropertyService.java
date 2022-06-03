package com.xiaofei.service;

import com.xiaofei.entity.Property;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 22:34
 * Description:
 */
public interface PropertyService {
    List<Property> getPropertyList();
    Property getPropertyById(Long id);
    void updateProperty(Property property);
}
