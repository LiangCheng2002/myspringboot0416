package com.work.lc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装登录页面的用户信息
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
