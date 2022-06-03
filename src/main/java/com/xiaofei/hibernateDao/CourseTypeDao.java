package com.xiaofei.hibernateDao;

import com.xiaofei.entity.CourseType;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 11:32
 * Description:
 */
public interface CourseTypeDao {
    CourseType getCourseTypeByCourseId(Long id);
    CourseType getCourseTypeByCourseName(String courseName);
}
