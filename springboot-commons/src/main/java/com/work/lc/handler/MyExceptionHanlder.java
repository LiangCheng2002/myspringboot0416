package com.work.lc.handler;


import com.work.lc.model.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理接口
@Slf4j
@RestControllerAdvice
public class MyExceptionHanlder {

    @ExceptionHandler(Exception.class)
    public ResponseResult handlerException(Exception e){
      if(e instanceof UsernameNotFoundException){
          log.info("用户名或密码错误:{}",e.getMessage());
          return new ResponseResult("用户名或密码错误",e.getMessage());
      }
      return new ResponseResult(e.getMessage(),null);
    }
}
