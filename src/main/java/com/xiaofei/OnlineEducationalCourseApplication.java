package com.xiaofei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan (value = "com.xiaofei.mybatisDao")
public class OnlineEducationalCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineEducationalCourseApplication.class, args);
    }

}
