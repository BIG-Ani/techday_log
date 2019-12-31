package com.chenleizhou.techlog.mapper;

import com.chenleizhou.techlog.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void newUser(User user);

    User findUserByName(String name);
}
