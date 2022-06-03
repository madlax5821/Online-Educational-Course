package com.xiaofei.mybatisDao;

import com.xiaofei.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 12:23
 * Description:
 */
@Repository ("mybatisCourseDao")
public interface CourseDao {

    List<Course> getHktjList();
    List<Course> getZxkcList();
    List<Course> getMfkcList();
    List<Course> getSzkcList();
    
    
    List<Course> adminSearchHktj();
    List<Course> adminSearchZxkc();
    List<Course> adminSearchMfkc();
    List<Course> adminSearchSzkc();
    
    Course getCourseByCourseId(Long id);
    Course lazyFetchCourseByCourseId(Long id);
    
    Integer updateCourse(Course course);
    void updateHktj(Course course);
    void updateZxkc(Course course);
    void updateMfkc(Course course);
    void updateSzkc(Course course);
    
    List<Course> getRecommendCourseList();
    List<Course> getCoursesByCourseTypeId(Long courseTypeId);
    List<Course> searchCourseByConditions(Map<String, Object> map);
    List<Course> adminSearchCourses(Map<String, Object> map);
    Long getTotalAmount(Map<String, Object> map);
    
    List<Course> getAllCourses();
    
    void deleteCourseById(Long id);
    void saveCourse(Course course);
    ;
    
}
