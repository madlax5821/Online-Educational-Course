package com.xiaofei.testConnection;

import com.xiaofei.entity.Teacher;
import com.xiaofei.mybatisDao.CourseTypeDao;
import com.xiaofei.mybatisDao.TeacherDao;
import com.xiaofei.service.CourseService;
import com.xiaofei.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 12:58
 * Description:
 */

@SpringBootTest
class DataSourceTest {
    
    @Autowired
    private CourseService courseService;
    
    
    
    @Test
    public void testData(){
        System.out.println(courseService.getRecommendCourseList());
        System.out.println("================================================");
        //System.out.println(courseService.getCourseByCourseId(86L));
    }
}
