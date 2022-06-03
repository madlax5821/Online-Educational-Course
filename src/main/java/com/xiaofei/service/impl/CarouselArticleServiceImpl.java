package com.xiaofei.service.impl;

import com.xiaofei.entity.CarouselArticle;
import com.xiaofei.mybatisDao.CarouselArticleDao;
import com.xiaofei.service.CarouselArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 23:09
 * Description:
 */
@Service
public class CarouselArticleServiceImpl implements CarouselArticleService {

    @Autowired
    @Qualifier("mybatisCarouselArticleDao")
    private CarouselArticleDao carouselArticleDao;
    
    @Override
    public List<CarouselArticle> getCarouselArticleList() {
        return carouselArticleDao.getCarouselArticleList();
    }

    @Override
    public CarouselArticle getCarouselArticleById(Long id) {
        return carouselArticleDao.getCarouselArticleById(id);
    }

    @Override
    public void saveCarouselArticle(CarouselArticle carouselArticle) {
        carouselArticleDao.saveCarouselArticle(carouselArticle);
    }

    @Override
    public void updateCarouselArticle(CarouselArticle carouselArticle) {
        carouselArticleDao.updateCarouselArticle(carouselArticle);
    }

    @Override
    public void deleteCarouselArticleById(Long id) {
        carouselArticleDao.deleteCarouselArticleById(id);
    }
}
