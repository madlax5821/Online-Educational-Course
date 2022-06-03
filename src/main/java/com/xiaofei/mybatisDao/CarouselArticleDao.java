package com.xiaofei.mybatisDao;

import com.xiaofei.entity.CarouselArticle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 23:01
 * Description:
 */
@Repository ("mybatisCarouselArticleDao")
public interface CarouselArticleDao {
    List<CarouselArticle> getCarouselArticleList(); 
    CarouselArticle getCarouselArticleById(Long id);
    void saveCarouselArticle(CarouselArticle carouselArticle);
    void updateCarouselArticle(CarouselArticle carouselArticle);
    void deleteCarouselArticleById(Long id);
}
