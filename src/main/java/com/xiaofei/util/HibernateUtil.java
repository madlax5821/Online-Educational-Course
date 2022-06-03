package com.xiaofei.util;

import com.xiaofei.entity.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 15:33
 * Description:
 */
public class HibernateUtil {
    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    private static SessionFactory factory;
    private static Session session;
    
    static {
        try {
            generateFactory();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    private static SessionFactory generateFactory() {
        String url = System.getProperty("hibernate.url");
        String driver = System.getProperty("hibernate.driver");
        String username = System.getProperty("hibernate.username");
        String password = System.getProperty("hibernate.password");
        String dialect = System.getProperty("hibernate.dialect");

        Properties settings = new Properties();

        Configuration configuration = new Configuration();
        
        settings.put(Environment.URL,url);
        settings.put(Environment.DRIVER,driver);
        settings.put(Environment.USER,username);
        settings.put(Environment.PASS,password);
        settings.put(Environment.DIALECT,dialect);
        settings.put(Environment.FORMAT_SQL,"true");
        settings.put(Environment.SHOW_SQL,"true");
        settings.put(Environment.HBM2DDL_AUTO,"validate");
        settings.put(Environment.HBM2DDL_AUTO,"update");
        
        configuration.addProperties(settings);
        configuration.addAnnotatedClass(Menu.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        StandardServiceRegistry standardServiceRegistry = builder.applySettings(configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(standardServiceRegistry);
        return factory;
    }
    
    public static Session getSession(){
        try {
            session = factory.openSession();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return session;
    }
    
    public static void close(){
        session.close();
    }
}
