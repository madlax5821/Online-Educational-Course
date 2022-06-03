package com.xiaofei.service.impl;

import com.xiaofei.entity.CourseType;
import com.xiaofei.mybatisDao.CourseTypeDao;
import com.xiaofei.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-27, 18:41
 * Description:
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    @Qualifier ("mybatisCourseTypeDao")
    private CourseTypeDao courseTypeDao;
    
    @Override
    public List<CourseType> findAllCourseTypes() {
        return courseTypeDao.getAllCourseTypes();
    }

    public CourseTypeDao getCourseTypeDao() {
        return courseTypeDao;
    }

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Override
    public void deleteCourseTypeByTypeId(Long typeId) {
        courseTypeDao.deleteCourseType(typeId);
    }

    @Override
    public void addCourseType(CourseType courseType) {
        courseTypeDao.saveCourseType(courseType);
    }

    @Override
    public void updateCourseType(CourseType courseType) {
        courseTypeDao.updateCourseType(courseType);
    }

    @Override
    public CourseType findCourseTypeByCourseId(Long typeId) {
        return courseTypeDao.getCourseTypeById(typeId);
    }
}
