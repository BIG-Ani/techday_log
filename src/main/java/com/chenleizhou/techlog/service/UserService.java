package com.chenleizhou.techlog.service;

import com.chenleizhou.techlog.entity.User;
import com.chenleizhou.techlog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserMapper {

    @Autowired
    UserMapper userMapper;


    @Override
    public void newUser(User user) {
        userMapper.newUser(user);
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }
}
