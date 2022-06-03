package com.xiaofei.controller.admin;

import com.xiaofei.entity.Teacher;
import com.xiaofei.service.TeacherService;
import com.xiaofei.util.DateUtil;
import com.xiaofei.util.ResponseResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-29, 2:08
 * Description:
 */
@Controller
@RequestMapping("/admin/teacher")
public class TeacherAdminController {
    @Autowired
    private TeacherService teacherService;
    @Value("${teacherImagePath}")
    private String teacherImagePath;
    
    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult getAllTeachers(){
        try {
            List<Teacher> teachers = teacherService.getAllTeachers();
            return ResponseResult.success(teachers);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/deleteTeacherById")
    @ResponseBody
    public ResponseResult deleteTeacherById(Long id){
        try {
            teacherService.deleteTeacherById(id);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/findTeacherById")
    @ResponseBody
    public ResponseResult getTeacherById(Long id){
        try {
            Teacher teacher = teacherService.getTeacherById(id);
            return ResponseResult.success(teacher);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/saveTeacher")
    @ResponseBody
    public ResponseResult saveOrUpdateTeacher(Teacher teacher){
        Teacher t = teacherService.getTeacherById(teacher.getId());
        if (t==null){
            teacherService.saveTeacher(teacher);
            return ResponseResult.success();
        }
        teacherService.updateTeacher(teacher);
        return ResponseResult.success();
    }
    
    @RequestMapping("/uploadTeacherImage")
    @ResponseBody
    public ResponseResult uploadTeacherImage(MultipartFile file, Long id) throws Exception{
        if (file!=null){
            try {
                String fileName = file.getOriginalFilename();
                fileName=fileName.substring(fileName.lastIndexOf("."));
                fileName= DateUtil.getCurrentDateStr()+fileName;
                FileUtils.copyInputStreamToFile(file.getInputStream(),new File(teacherImagePath+fileName));
                Teacher teacher = teacherService.getTeacherById(id);
                teacher.setImageName(fileName);
                teacherService.updateTeacher(teacher);
                return ResponseResult.success();
            }catch (Exception e){

                return ResponseResult.fail(e.getMessage());
            }
        }
        return ResponseResult.fail("file doesn't exist");
    }
}
