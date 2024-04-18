package com.work.lc.controller;


import com.work.lc.model.ResponseResult;
import com.work.lc.service.Impl.LoginServiceImpl;
import com.work.lc.service.LoginService;
import com.work.lc.vo.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginDetails loginDetails){
        if(loginDetails.getUsername() == null){
            throw new RuntimeException("登录名和密码不能为空");
        }
        return loginService.login(loginDetails);
    }

    @GetMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
