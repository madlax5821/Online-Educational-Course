package com.xiaofei.service.impl;

import com.xiaofei.entity.Course;
import com.xiaofei.exception.CourseNotFoundException;
import com.xiaofei.mybatisDao.CourseDao;
import com.xiaofei.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 19:42
 * Description:
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    @Qualifier ("mybatisCourseDao")
    private CourseDao courseDao;
    
    @Override
    public List<Course> getHktjList() {
        return courseDao.getHktjList();
    }

    @Override
    public List<Course> getZxkcList() {
        return courseDao.getZxkcList();
    }

    @Override
    public List<Course> getMfkcList() {
        return courseDao.getMfkcList();
    }

    @Override
    public List<Course> getSzkcList() {
        return courseDao.getSzkcList();
    }

    @Override
    public Course getCourseByCourseId(Long courseId) throws CourseNotFoundException {
        
        Course course = courseDao.getCourseByCourseId(courseId);
        if (course==null){
            throw new CourseNotFoundException("course doesn't exist");
        }
        return course;
    }
    @Override
    public Course lazyFetchCourseByCourseId(Long courseId) {
        return courseDao.lazyFetchCourseByCourseId(courseId);
    }

    @Override
    public Integer updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public List<Course> getRecommendCourseList() {
        return courseDao.getRecommendCourseList();
    }

    @Override
    public List<Course> findAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public List<Course> searchCourseByConditions(Map<String, Object> map) {
        return courseDao.searchCourseByConditions(map);
    }

    @Override
    public List<Course> adminSearchCourses(Map<String, Object> map) {
        return courseDao.adminSearchCourses(map);
    }

    @Override
    public Long getTotalAmount(Map<String, Object> map) {
        return courseDao.getTotalAmount(map);
    }

    @Override
    public void deleteCourseById(Long id) throws Exception {
        try {
            courseDao.deleteCourseById(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public List<Course> adminSearchHktj() {
        return courseDao.adminSearchHktj();
    }

    @Override
    public List<Course> adminSearchZxkc() {
        return courseDao.adminSearchZxkc();
    }

    @Override
    public List<Course> adminSearchMfkc() {
        return courseDao.adminSearchMfkc();
    }

    @Override
    public List<Course> adminSearchSzkc() {
        return courseDao.adminSearchSzkc();
    }

    @Override
    public void updateHktj(Course course) {
        courseDao.updateHktj(course);
    }

    @Override
    public void updateZxkc(Course course) {
        courseDao.updateZxkc(course);
    }

    @Override
    public void updateMfkc(Course course) {
        courseDao.updateMfkc(course);
    }

    @Override
    public void updateSzkc(Course course) {
        courseDao.updateSzkc(course);
    }

    @Override
    public List<Course> adminSearchFreeCourses(HashMap<String, Object> map) {
        return courseDao.adminSearchCourses(map);
    }
}
