package com.example.fabric.exception;


import com.example.fabric.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器
//@RestControllerAdvice
public class GOP {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result ex(Exception exception){
        exception.printStackTrace();
        return Result.error("操作失败，请联系管理员！");
    }
}
