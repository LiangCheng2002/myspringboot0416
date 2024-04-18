package com.work.lc.controller;


import com.work.lc.model.ResponseResult;
import com.work.lc.service.LoginService;
import com.work.lc.vo.LoginDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户登录接口")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseResult login(@RequestBody LoginDetails loginDetails){
        if(loginDetails.getUsername() == null){
            log.info("登录名或密码为空：{}",loginDetails);
            throw new RuntimeException("登录名和密码不能为空");
        }
        return loginService.login(loginDetails);
    }

    @GetMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
