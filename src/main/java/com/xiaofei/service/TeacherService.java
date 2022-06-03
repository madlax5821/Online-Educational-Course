package com.xiaofei.service;

import com.xiaofei.entity.Teacher;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-29, 2:08
 * Description:
 */
public interface TeacherService {
    List<Teacher> getAllTeachers() throws Exception;

    void deleteTeacherById(Long id);

    Teacher getTeacherById(Long id);

    void saveTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);
}
