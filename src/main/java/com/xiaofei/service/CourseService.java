package com.xiaofei.service;

import com.xiaofei.entity.Course;
import com.xiaofei.exception.CourseNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 19:42
 * Description:
 */

public interface CourseService {
    List<Course> getHktjList();
    List<Course> getZxkcList();
    List<Course> getMfkcList();
    List<Course> getSzkcList();
    
    List<Course> adminSearchHktj();
    List<Course> adminSearchZxkc();
    List<Course> adminSearchMfkc();
    List<Course> adminSearchSzkc();

    Course getCourseByCourseId(Long courseId) throws CourseNotFoundException;
    Course lazyFetchCourseByCourseId(Long courseId);
    
    Integer updateCourse(Course course);
    void updateHktj(Course course);
    void updateZxkc(Course course);
    void updateMfkc(Course course);
    void updateSzkc(Course course);
    
    List<Course> getRecommendCourseList();

    List<Course> findAllCourses();

    List<Course> searchCourseByConditions(Map<String, Object> map);
    List<Course> adminSearchCourses(Map<String, Object> map);
    Long getTotalAmount(Map<String, Object> map);

    void deleteCourseById(Long id) throws Exception;
    void saveCourse(Course course);


    List<Course> adminSearchFreeCourses(HashMap<String, Object> map);
}
