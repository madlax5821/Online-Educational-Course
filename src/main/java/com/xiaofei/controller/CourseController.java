package com.xiaofei.controller;

import com.xiaofei.entity.Course;
import com.xiaofei.entity.PageBean;
import com.xiaofei.exception.CourseNotFoundException;
import com.xiaofei.service.CourseService;
import com.xiaofei.util.PageUtil;
import com.xiaofei.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-26, 0:16
 * Description:
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("/{courseId}")
    public String retrieveCourseByCourseId (@PathVariable Long courseId, Model model) throws CourseNotFoundException {
        Course course = courseService.getCourseByCourseId(courseId);
        List<Course> recommendCourseList = courseService.getRecommendCourseList();
        model.addAttribute("course", course);
        model.addAttribute("ranRecommendList",recommendCourseList);
        return "/course";
    }
    @ResponseBody
    @RequestMapping("/updateView")
    public void updateCourse(Long id) throws Exception{
        Course course = courseService.getCourseByCourseId(id);
        course.setView(course.getView()+1);
        courseService.updateCourse(course);
    }
    
    @RequestMapping("/list")
    public ModelAndView findCourses(){
        ModelAndView mav =new ModelAndView();
        mav.addObject("title","course list");
        PageBean pageBean = new PageBean(1,20);
        Map<String, Object> map = new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        List<Course> courseList = courseService.searchCourseByConditions(map);
        Long totalAmount = courseService.getTotalAmount(map);
        mav.addObject("courseList",courseList);
        mav.addObject("clearSessionStorage","yes");
        
        StringBuffer param = new StringBuffer();
        mav.addObject("pageCode", PageUtil.genPagination("/course/list",totalAmount,1,20,param.toString()));
        mav.setViewName("courseList");
        return mav;
    }
    
    @RequestMapping("/list/{page}")
    public ModelAndView searchCoursesByConditions(
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "typeId",required = false) Integer typeId,
            @RequestParam(value = "type",required = false) String type,
            @PathVariable(value = "page",required = false) Integer page){
        if (page==null){
            page=1;
        }
        ModelAndView mav =new ModelAndView();
        mav.addObject("title","page:"+page);
        PageBean pageBean = new PageBean(page,20);
        
        Map<String, Object> map = new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        if (StringUtil.isNotEmpty(name)){
            map.put("name",name.trim());
        }
        map.put("type",type);
        map.put("typeId",typeId);
        
        List<Course> courseList = courseService.searchCourseByConditions(map);
        Long totalAmount = courseService.getTotalAmount(map);
        mav.addObject("courseList",courseList);
        
        StringBuffer param = new StringBuffer();
        if(StringUtil.isNotEmpty(name)){
            param.append("&name="+name);
        }
        if(typeId!=null){
            param.append("&typeId="+typeId);
        }
        if(type!=null){
            param.append("&type="+type);
        }
        mav.addObject("name",name);
        mav.addObject("pageCode", PageUtil.genPagination("/course/list",totalAmount,page,20,param.toString()));
        mav.setViewName("courseList");
        return mav;
    }
}
