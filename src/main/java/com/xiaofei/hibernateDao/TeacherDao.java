package com.xiaofei.hibernateDao;

import com.xiaofei.entity.Teacher;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 11:32
 * Description:
 */
public interface TeacherDao {
    Teacher getTeacherByCourseId(Long id);
    Teacher getTeacherByCourseName(String courseName);
    List<Teacher> getAllTeachers();
}
