package com.atguigu.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zhangtao
 * @date 2022/5/25 - 19:40
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class}) //处理异常
    public String handleArith(Exception e){
        log.error("异常是：{}",e);
        return "login";//视图地址
    }
}