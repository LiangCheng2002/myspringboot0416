package com.work.lc.controller;


import com.work.lc.model.ResponseResult;
import com.work.lc.service.Impl.LoginServiceImpl;
import com.work.lc.vo.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @GetMapping("/login")
    public ResponseResult login(@RequestBody LoginDetails loginDetails){
        if(loginDetails==null){
            throw new RuntimeException("登录名和密码不能为空");
        }
        return loginService.login(loginDetails);
    }

    @GetMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
