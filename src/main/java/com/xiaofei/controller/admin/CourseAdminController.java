package com.xiaofei.controller.admin;

import com.xiaofei.entity.Course;
import com.xiaofei.entity.PageBean;
import com.xiaofei.service.CourseService;
import com.xiaofei.startup.StartupRunner;
import com.xiaofei.util.DateUtil;
import com.xiaofei.util.ResponseResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-28, 20:10
 * Description:
 */
@Controller
@RequestMapping("/admin/course")
public class CourseAdminController {
    @Autowired
    private CourseService courseService;
    
    @Value("${courseImageFilePath}")
    private String courseImagePath;
    @Value("${postImagePath}")
    private String postImagePath;
    
    @Autowired
    private StartupRunner runner;
    
    @RequestMapping("/freeCourseList")
    @ResponseBody
    public Map<String, Object> searchForFreeCourseList(
            @RequestParam(value = "page",required = false) Integer page,
            @RequestParam(value = "limit",required = false) Integer limit,
            @RequestParam(value = "name",required = false) String name) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        PageBean pageBean = new PageBean(page, limit);
        int start = pageBean.getStart();
        map.put("start",start);
        map.put("size",limit);
        map.put("name",name);
        map.put("type","free");

        Map<String, Object> resultMap = new HashMap<>();
        
        try {
            Long totalAmount = courseService.getTotalAmount(map);
            List<Course> courses = courseService.adminSearchFreeCourses(map);
            resultMap.put("code",0);
            resultMap.put("count",totalAmount);
            resultMap.put("data",courses);
            return resultMap;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    @RequestMapping("/vipCourseList")
    @ResponseBody
    public Map<String, Object> searchForVipCourseList(
            @RequestParam(value = "page",required = false) Integer page,
            @RequestParam(value = "limit",required = false) Integer limit,
            @RequestParam(value = "name",required = false) String name) throws Exception {
        Map<String, Object> parameterMap = new HashMap<>();
        PageBean pageBean = new PageBean(page, limit);
        int start = pageBean.getStart();
        parameterMap.put("start",start);
        parameterMap.put("size",limit);
        parameterMap.put("name",name);
        parameterMap.put("type","vip");
        
        Map<String, Object> resultMap = new HashMap<>();
        
        try {
            Long totalAmount = courseService.getTotalAmount(parameterMap);
            List<Course> courses = courseService.adminSearchCourses(parameterMap);
            resultMap.put("code",0);
            resultMap.put("count",totalAmount);
            resultMap.put("data",courses);
            return resultMap;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> manageAllCourses(
            @RequestParam(value = "page",required = false)Integer page,
            @RequestParam(value = "limit",required = false)Integer limit,
            @RequestParam(value = "name",required = false)String name) throws Exception {
        Map<String, Object> map = new HashMap<>();
        
        PageBean pageBean = new PageBean(page, limit);
        int start = pageBean.getStart();
        map.put("start",start);
        map.put("size",limit);
        map.put("name",name);

        Map<String, Object> resultMap = new HashMap<>();
        try {
            Long totalAmount = courseService.getTotalAmount(map);
            List<Course> courseList = courseService.adminSearchCourses(map);
            resultMap.put("code",0);
            resultMap.put("count",totalAmount);
            resultMap.put("data",courseList);
            return resultMap;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    } 
    
    @ResponseBody
    @RequestMapping("/findCourseById")
    public Map<String, Object> findCourseById(Long id) throws Exception{
        Map<String, Object> resultMap = new HashMap<>();
        Course course = courseService.getCourseByCourseId(id);
        resultMap.put("course",course);
        resultMap.put("success",true);
        return resultMap;
    }
    
    @ResponseBody
    @RequestMapping("/uploadImage")
    public Map<String, Object> uploadImage(Long id, MultipartFile file) throws Exception{
        Map<String, Object> map = new HashMap<>();
        
        
        if (!file.isEmpty()){
            String filename = file.getOriginalFilename();
            int dotIndex = filename.lastIndexOf(".");
            filename=filename.substring(dotIndex);
            filename = DateUtil.getCurrentDateStr()+filename;
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(courseImagePath+filename));
            map.put("code",0);
            map.put("msg","success");
            map.put("code",0);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("title",filename);
            resultMap.put("src","/courseImage/"+filename);
            map.put("data",resultMap);

            Course course = courseService.getCourseByCourseId(id);
            course.setImageName(filename);
            courseService.updateCourse(course);
            
            runner.initializeData();
        }
        
        return map;
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseResult deleteCourseById(Long id){
        try {
            courseService.deleteCourseById(id);
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/addFreeCourse")
    @ResponseBody
    public ResponseResult addFreeCourse(Course course){
        try {
            course.setImageName("test.jpg");
            course.setType("free");
            courseService.saveCourse(course);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/addVIPCourse")
    @ResponseBody
    public ResponseResult addVIPCourse(Course course){
        try {
            course.setImageName("test.jpg");
            course.setType("vip");
            courseService.saveCourse(course);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/ckeditorUpload")
    @ResponseBody
    public String addImageInCkEditor(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception{
        if (!file.isEmpty()){
            String filename = file.getOriginalFilename();
            int lastDotIndex = filename.lastIndexOf(".");
            filename=filename.substring(lastDotIndex);
            filename=DateUtil.getCurrentDateStr()+filename;
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(postImagePath+filename));

            StringBuffer sb=new StringBuffer();
            sb.append("<script type=\"text/javascript\">");
            sb.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" +"/articleImages/"+ filename + "','')");
            sb.append("</script>");

            return sb.toString();
        }
        return null;
    }
    
    @ResponseBody
    @RequestMapping("/modifyCourse")
    public ResponseResult modifyCourse(Course course){
        try {
            courseService.updateCourse(course);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/hktjList")
    @ResponseBody
    public ResponseResult getHktjList(){
        try {
            List<Course> courses = courseService.adminSearchHktj();
            return ResponseResult.success(courses);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        } 
    }

    @RequestMapping("/szkcList")
    @ResponseBody
    public ResponseResult getSzkcList(){
        try {
            List<Course> courses = courseService.adminSearchSzkc();
            return ResponseResult.success(courses);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/zxkcList")
    @ResponseBody
    public ResponseResult getZxkcList(){
        try {
            List<Course> courses = courseService.adminSearchZxkc();
            return ResponseResult.success(courses);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/mfkcList")
    @ResponseBody
    public ResponseResult getMfkcList(){
        try {
            List<Course> courses = courseService.adminSearchMfkc();
            return ResponseResult.success(courses);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/updateHktj")
    @ResponseBody
    public ResponseResult updateHktj(Course course){
        try {
            courseService.updateHktj(course);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/updateZxkc")
    @ResponseBody
    public ResponseResult updateZxkc(Course course){
        try {
            courseService.updateZxkc(course);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/updateMfkc")
    @ResponseBody
    public ResponseResult updateMfkc(Course course){
        try {
            courseService.updateMfkc(course);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/updateSzkc")
    @ResponseBody
    public ResponseResult updateSzkc(Course course){
        try {
            courseService.updateSzkc(course);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
}
