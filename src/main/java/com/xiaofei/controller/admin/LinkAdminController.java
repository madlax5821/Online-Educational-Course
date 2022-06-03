package com.xiaofei.controller.admin;

import com.xiaofei.entity.Link;
import com.xiaofei.service.LinkService;
import com.xiaofei.startup.StartupRunner;
import com.xiaofei.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-22, 13:43
 * Description:
 */
@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {
    @Autowired
    private LinkService linkService;
    @Autowired
    private StartupRunner runner;
    
    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult findLinkList(){
        try {
            List<Link> linkList = linkService.getLinkList();
            return ResponseResult.success(linkList);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/findLinkById")
    @ResponseBody
    public ResponseResult findLinkById(Long id){
        try {
            Link link= linkService.getLinkById(id);
            return ResponseResult.success(link);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/deleteLinkById")
    @ResponseBody
    public ResponseResult deleteLinkById(Long id){
        try {
            linkService.deleteLinkById(id);
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/saveLink")
    @ResponseBody
    public ResponseResult saveOrUploadLink(Link link){
        Link linkById = linkService.getLinkById(link.getId());
        try {
            if (linkById==null){
                linkService.saveLink(link);
            }else {

                linkService.updateLink(link);
            }
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
}
