package com.work.lc.service.Impl;

import com.work.lc.model.ResponseResult;
import com.work.lc.model.ResponseStatus;
import com.work.lc.service.LoginService;
import com.work.lc.util.JwtUtil;
import com.work.lc.util.RedisCache;
import com.work.lc.vo.LoginDetails;
import com.work.lc.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;

/**
 * 用户登录服务
 *
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    public ResponseResult login(LoginDetails loginDetails) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDetails.getUsername(), loginDetails.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if(ObjectUtils.isEmpty(authenticate)) {
            log.info("用户名或密码错误");
            throw new RuntimeException("用户用户名或密码错误");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        log.info("用户登录成功");
        return new ResponseResult(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMessage(),map);
    }

    /**
     * 用户登出时，删除redis中的存储的用户信息
     * 从应用上下文的Authentication中拿到authentication信息
     */
    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        redisCache.deleteObject("login:"+userId);
        return new ResponseResult(200,"退出成功");
    }
}
