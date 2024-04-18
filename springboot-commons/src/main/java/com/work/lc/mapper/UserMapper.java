package com.work.lc.mapper;

import com.work.lc.model.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>, BaseMapper<User> {
}
