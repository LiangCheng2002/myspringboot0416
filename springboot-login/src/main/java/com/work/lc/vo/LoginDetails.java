package com.work.lc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDetails {
    /**
     * 用户登录名称
     *
     */
    private String username;
    /**
     * 用户密码
     *
     */
    private String password;


}
