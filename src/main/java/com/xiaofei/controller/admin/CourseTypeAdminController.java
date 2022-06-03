package com.xiaofei.controller.admin;

import com.xiaofei.entity.CourseType;
import com.xiaofei.service.CourseTypeService;
import com.xiaofei.startup.StartupRunner;
import com.xiaofei.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-29, 1:53
 * Description:
 */
@Controller
@RequestMapping("/admin/courseType")
public class CourseTypeAdminController {
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private StartupRunner runner;
    
    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult getAllCourseTypes(){
        List<CourseType> courseTypes = courseTypeService.findAllCourseTypes();
        return ResponseResult.success(courseTypes);
    }
    
    @RequestMapping("/deleteCourseType")
    @ResponseBody
    public ResponseResult deleteCourseTypeByTypeId(Long id){
        try {
            courseTypeService.deleteCourseTypeByTypeId(id);
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/saveCourseType")
    @ResponseBody
    public ResponseResult saveOrUpdateCourseTypeByTypeId(CourseType courseType){
        CourseType type = courseTypeService.findCourseTypeByCourseId(courseType.getId());
        if (type==null){
            courseTypeService.addCourseType(courseType);
            runner.initializeData();
            return ResponseResult.success();
        }
        courseTypeService.updateCourseType(courseType);
        return ResponseResult.success();
    }
    
    
    @RequestMapping("/findCourseType")
    @ResponseBody
    public ResponseResult findCourseTypeById(Long id){
        try {
            CourseType courseType = courseTypeService.findCourseTypeByCourseId(id);
            return ResponseResult.success(courseType);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
}
