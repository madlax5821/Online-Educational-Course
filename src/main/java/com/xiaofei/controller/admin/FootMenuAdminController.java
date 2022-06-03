package com.xiaofei.controller.admin;

import com.xiaofei.entity.FootMenu;
import com.xiaofei.service.FootMenuService;
import com.xiaofei.startup.StartupRunner;
import com.xiaofei.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-30, 20:20
 * Description:
 */
@RequestMapping("/admin/footMenu")
@Controller
public class FootMenuAdminController {
    @Autowired
    private FootMenuService footMenuService;
    @Autowired
    private StartupRunner runner;
    
    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult findFootMenuList(){
        try {
            List<FootMenu> footMenus = footMenuService.getAllFootMenus();
            return ResponseResult.success(footMenus);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/deleteFootMenuById")
    @ResponseBody
    public ResponseResult deleteFootMenuById(Long id){
        try {
            footMenuService.deleteFootMenuById(id);
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/findFootMenuById")
    @ResponseBody
    public ResponseResult findFootMenuById(Long id){
        try {
            FootMenu footMenu = footMenuService.getFootMenuById(id);
            return ResponseResult.success(footMenu);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/saveFootMenu")
    @ResponseBody
    public ResponseResult saveOrUpdateFootMenu(FootMenu footMenu){
        FootMenu menu = footMenuService.getFootMenuById(footMenu.getId());
        try {
            if (menu==null){
                footMenuService.saveFootMenu(footMenu);
            }else {
                footMenuService.updateFootMenu(footMenu);
            }
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
}
