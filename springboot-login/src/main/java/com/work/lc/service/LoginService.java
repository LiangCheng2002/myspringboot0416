package com.work.lc.service;

import com.work.lc.model.ResponseResult;
import com.work.lc.vo.LoginDetails;

public interface LoginService {
    ResponseResult login(LoginDetails loginDetails);

    ResponseResult logout();
}
