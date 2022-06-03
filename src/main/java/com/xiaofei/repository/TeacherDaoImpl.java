package com.xiaofei.repository;

import com.xiaofei.entity.Teacher;
import com.xiaofei.hibernateDao.TeacherDao;
import com.xiaofei.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 14:14
 * Description:
 */
@Repository ("hibernateTeacherDao")
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public Teacher getTeacherByCourseId(Long id) {
        String hql_getTeacherByCourseId="from Teacher t left join fetch t.courses c where c.id=:id";
        try (Session session = HibernateUtil.getSession()){
            Query<Teacher> query = session.createQuery(hql_getTeacherByCourseId);
            query.setParameter("id",id);
            return query.uniqueResult();
        }
    }

    @Override
    public Teacher getTeacherByCourseName(String courseName) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        String hql_getAllTeachers="from Teacher";
        try (Session session = HibernateUtil.getSession()){
            Query<Teacher> query = session.createQuery(hql_getAllTeachers);
            return query.getResultList();
        }
    }
}
