package com.xiaofei.service;

import com.xiaofei.entity.CarouselArticle;
import com.xiaofei.entity.Menu;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 20:18
 * Description:
 */
public interface CarouselArticleService {
    List<CarouselArticle> getCarouselArticleList();
    CarouselArticle getCarouselArticleById(Long id);
    void saveCarouselArticle(CarouselArticle carouselArticle);
    void updateCarouselArticle(CarouselArticle carouselArticle);
    void deleteCarouselArticleById(Long id);
}
