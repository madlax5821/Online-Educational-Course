package com.xiaofei.controller.admin;

import com.xiaofei.entity.CarouselArticle;
import com.xiaofei.service.CarouselArticleService;
import com.xiaofei.startup.StartupRunner;
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
 * Date: 2022-05-30, 22:55
 * Description:
 */
@Controller
@RequestMapping("/admin/carouselArticle")
public class CarouselArticleAdminController {
    @Autowired
    private CarouselArticleService carouselArticleService;
    @Autowired
    private StartupRunner runner;
    @Value("${carouselArticleImagePath}")
    private String carouselArticleImagePath;
    
    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult findCarouselArticleList(){
        try {
            List<CarouselArticle> carouselArticleList = carouselArticleService.getCarouselArticleList();
            return ResponseResult.success(carouselArticleList);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/findCarouselArticleById")
    @ResponseBody
    public ResponseResult findCarouselArticleById(Long id){
        try {
            CarouselArticle carouselArticle = carouselArticleService.getCarouselArticleById(id);
            return ResponseResult.success(carouselArticle);
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/deleteCarouselArticleById")
    @ResponseBody
    public ResponseResult deleteCarouselArticleById(Long id){
        try {
            carouselArticleService.deleteCarouselArticleById(id);
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/saveCarouselArticle")
    @ResponseBody
    public ResponseResult saveOrUpdateCarouselArticleById(CarouselArticle carouselArticle){
        CarouselArticle carouselArticleById = carouselArticleService.getCarouselArticleById(carouselArticle.getId());
        try {
            if (carouselArticleById==null){
                carouselArticleService.saveCarouselArticle(carouselArticle);
            }else {
                carouselArticleService.updateCarouselArticle(carouselArticle);
            }
            runner.initializeData();
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail(e.getMessage());
        }
    }
    
    @RequestMapping("/uploadImage")
    @ResponseBody
    public ResponseResult uploadImage(MultipartFile file, Long id) throws Exception {
        if (file!=null){
            try {
                String filename = file.getOriginalFilename();
                filename = filename.substring(filename.lastIndexOf("."));
                filename= DateUtil.getCurrentDateStr();
                FileUtils.copyInputStreamToFile(file.getInputStream(),new File(carouselArticleImagePath+filename));
                CarouselArticle carouselArticle = carouselArticleService.getCarouselArticleById(id);
                carouselArticle.setImageName(filename);
                carouselArticleService.updateCarouselArticle(carouselArticle);
                runner.initializeData();
                return ResponseResult.success();
            }catch (Exception e){
                return ResponseResult.fail(e.getMessage());
            }
        }
        return ResponseResult.fail("file doesn't exist");
    }
}
