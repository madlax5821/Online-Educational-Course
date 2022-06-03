package com.xiaofei.exception;

/**
 * Author: xiaofei
 * Date: 2022-05-29, 14:32
 * Description:
 */
public class CourseNotFoundException extends Exception{

    public CourseNotFoundException() {
        super();
    }

    public CourseNotFoundException(String message) {
        super(message);
    }

    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourseNotFoundException(Throwable cause) {
        super(cause);
    }
}
