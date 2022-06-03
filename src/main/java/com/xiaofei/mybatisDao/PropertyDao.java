package com.xiaofei.mybatisDao;

import com.xiaofei.entity.Property;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 22:25
 * Description:
 */
@Repository("mybatisPropertyDao")
public interface PropertyDao {
    List<Property> getPropertyList();
    Property getPropertyById(Long id);
    void updateProperty(Property property);
}
