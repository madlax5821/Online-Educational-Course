package com.xiaofei.mybatisDao;

import com.xiaofei.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 12:20
 * Description:
 */
@Repository ("mybatisTeacherDao")
public interface TeacherDao {
    Teacher getTeacherByCourseId(Long courseId);
    Teacher getTeacherByCourseName(String courseName);
    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher teacher);

    void deleteTeacherById(Long id);

    void updateTeacher(Teacher teacher);

    Teacher getTeacherById(Long teacherId);
}
