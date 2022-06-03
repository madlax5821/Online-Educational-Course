package com.xiaofei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 16:26
 * Description:
 */
@Configuration
public class WebServiceMvcConfig implements WebMvcConfigurer {
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/courseImages/**").addResourceLocations("file:E:\\projectImages\\courseImages\\");
        registry.addResourceHandler("/articleImages/**").addResourceLocations("file:E:\\projectImages\\articleImages\\");
        registry.addResourceHandler("/carouselImages/**").addResourceLocations("file:E:\\projectImages\\carouselImages\\");
        registry.addResourceHandler("/systemImages/**").addResourceLocations("file:E:\\projectImages\\systemImages\\");
        registry.addResourceHandler("/teacherImages/**").addResourceLocations("file:E:\\projectImages\\teacherImages\\");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("login").setViewName("/login");
        registry.addViewController("admin").setViewName("/admin/main");
        registry.addViewController("index").setViewName("/index");
        registry.addViewController("500").setViewName("/error/500");
//        registry.addViewController("course").setViewName("/course");
//        //registry.addViewController("article").setViewName("/article");
//        registry.addViewController("courseList").setViewName("/courseList");
    }
}
