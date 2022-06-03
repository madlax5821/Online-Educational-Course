package com.xiaofei.service;

import com.xiaofei.entity.CourseType;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-27, 18:40
 * Description:
 */
public interface CourseTypeService {
    List<CourseType> findAllCourseTypes();

    void deleteCourseTypeByTypeId(Long typeId);
    
    void addCourseType(CourseType courseType);
    
    void updateCourseType(CourseType courseType);
    
    CourseType findCourseTypeByCourseId(Long typeId);
}
