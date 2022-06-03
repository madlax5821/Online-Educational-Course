package com.xiaofei.startup;

import com.xiaofei.entity.Property;
import com.xiaofei.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 20:23
 * Description:
 */
@Component ("startupRunner")
public class StartupRunner implements CommandLineRunner, ServletContextListener {

    private ServletContext applicationScope=null;
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private CarouselArticleService carouselArticleService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private FootMenuService footMenuService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private PropertyService propertyService;
    @Override
    public void run(String... args) throws Exception {
        this.initializeData();
    }
    
    public void initializeData(){
        List<Property> propertyList = propertyService.getPropertyList();
        Map<String, String> propertyMap = new HashMap<>();
        for (Property property:propertyList){
            propertyMap.put(property.getKey(),property.getValue());
        }
        
        applicationScope.setAttribute("propertyMap",propertyMap); //system attributes
        applicationScope.setAttribute("menuList",menuService.getMenuList());
        applicationScope.setAttribute("carouselArticleList",carouselArticleService.getCarouselArticleList());
        applicationScope.setAttribute("hktjList",courseService.getHktjList());
        applicationScope.setAttribute("szkcList",courseService.getSzkcList());
        applicationScope.setAttribute("zxkcList",courseService.getZxkcList());
        applicationScope.setAttribute("mfkcList",courseService.getMfkcList());
        applicationScope.setAttribute("footMenuList",footMenuService.getAllFootMenus());
        applicationScope.setAttribute("linkList",linkService.linkListPage(null));
        applicationScope.setAttribute("courseTypeList",courseTypeService.findAllCourseTypes());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        applicationScope=sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
