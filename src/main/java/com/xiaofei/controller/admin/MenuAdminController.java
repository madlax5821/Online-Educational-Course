package com.xiaofei.controller.admin;

import com.xiaofei.entity.Menu;
import com.xiaofei.service.MenuService;
import com.xiaofei.startup.StartupRunner;
import com.xiaofei.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-30, 19:13
 * Description:
 */
@Controller
@RequestMapping ("/admin/menu")
public class MenuAdminController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private StartupRunner runner;
    
    @RequestMapping("/saveMenu")
    @ResponseBody
    public ResponseResult addMenu(Menu menu){
        Menu m = menuService.getMenuById(menu.getId());
        try {
            if (m==null){
                menuService.saveMenu(menu);
            }else {
                menuService.updateMenu(menu);
            }
            runner.initializeData();
            
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult menuList(){
        try {
            List<Menu> menuList = menuService.getMenuList();
            return ResponseResult.success(menuList);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/deleteMenuById")
    @ResponseBody
    public ResponseResult deleteMenuById(Long id){
        try {
            menuService.deleteMenuById(id);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/findMenuById")
    @ResponseBody
    public ResponseResult findMenuById(Long id){
        try {
            Menu menu = menuService.getMenuById(id);
            return ResponseResult.success(menu);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
}
