package com.jifang.spittr.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 使用@ControllerAdvice，为所有的控制器处理异常
 * author: jifang
 * date: 18-4-9 下午10:54
 */
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(SpittleNotFoundException.class)
    public String spittleNotFoundHandler() {
        return "error/spittleNotFound";
    }

}
