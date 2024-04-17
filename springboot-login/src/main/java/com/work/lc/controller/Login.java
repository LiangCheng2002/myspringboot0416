package com.work.lc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devs")
public class Login {
    @GetMapping("/login")
    public String login(){
        //123456
        return "你好啊";
    }
}
