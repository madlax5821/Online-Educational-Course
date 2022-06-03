package com.xiaofei.repository;

import com.xiaofei.entity.Menu;
import com.xiaofei.hibernateDao.MenuDao;
import com.xiaofei.hibernateDao.UserDao;
import com.xiaofei.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 21:00
 * Description:
 */
@Repository (value = "hibernateMenuDao")
public class MenuDaoImpl implements MenuDao {

    @Override
    public List<Menu> getMenuList() {
        String hql_getMenuList="from Menu m order by m.sort";
        try (Session session = HibernateUtil.getSession()){
            Query<Menu> query = session.createQuery(hql_getMenuList);
            return query.list();
        }
    }

    public static void main(String[] args) {
        MenuDaoImpl menuDao = new MenuDaoImpl();
        System.out.println(menuDao.getMenuList());
    }
}
