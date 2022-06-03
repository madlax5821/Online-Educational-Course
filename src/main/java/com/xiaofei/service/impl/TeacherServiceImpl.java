package com.xiaofei.service.impl;

import com.xiaofei.entity.Teacher;
import com.xiaofei.mybatisDao.TeacherDao;
import com.xiaofei.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-29, 2:09
 * Description:
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    @Qualifier ("mybatisTeacherDao")
    private TeacherDao teacherDao;
    
    @Override
    public List<Teacher> getAllTeachers() throws Exception {
        try {
            return teacherDao.getAllTeachers();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteTeacherById(Long id) {
       teacherDao.deleteTeacherById(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherDao.saveTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }
}
