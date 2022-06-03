package com.xiaofei.controller.admin;

import com.xiaofei.entity.Property;
import com.xiaofei.service.PropertyService;
import com.xiaofei.startup.StartupRunner;
import com.xiaofei.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-30, 21:05
 * Description:
 */
@Controller
@RequestMapping("/admin/property")
public class PropertyAdminController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private StartupRunner runner;
    
    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult findPropertyList(){
        try {
            List<Property> propertyList = propertyService.getPropertyList();
            return ResponseResult.success(propertyList);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/findPropertyById")
    @ResponseBody
    public ResponseResult findPropertyById(Long id){
        try {
            Property property = propertyService.getPropertyById(id);
            return ResponseResult.success(property);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/updateProperty")
    @ResponseBody
    public ResponseResult updateProperty(Property property){
        try {
            propertyService.updateProperty(property);
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
}
