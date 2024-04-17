package com.work.lc.service.Impl;

import com.work.lc.mapper.UserMapper;
import com.work.lc.model.User;
import com.work.lc.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * UserDetailsService接口中的loadUserByUsername方法是用来查询用户是否存在
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", username);
        List<User> users = userMapper.selectByExample(example);
        if(users.size()>0){
            User user = users.get(0);
            return new LoginUser(user);

        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }
}
