package com.xiaofei.controller.advice;

import com.xiaofei.exception.CourseNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Author: xiaofei
 * Date: 2022-05-26, 0:19
 * Description:
 */
@ControllerAdvice
public class CourseControllerAdvice {
    @ExceptionHandler (value = CourseNotFoundException.class)
    public String courseError(Model model, CourseNotFoundException e){
         model.addAttribute("courseError", e.getMessage());
         return "error/500";
    }
}
