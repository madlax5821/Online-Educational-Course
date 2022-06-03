package com.xiaofei.mybatisDao;

import com.xiaofei.entity.CourseType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 12:22
 * Description:
 */
@Repository ("mybatisCourseTypeDao")
public interface CourseTypeDao {
    CourseType getCourseTypeByCourseId(Long courseId);
    CourseType getCourseTypeByCourseName(String courseName);
    List<CourseType> getAllCourseTypes();
    CourseType getCourseTypeById(Long courseTypeId);

    void updateCourseType(CourseType courseType);

    void saveCourseType(CourseType courseType);

    void deleteCourseType(Long typeId);
}
