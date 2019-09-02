package com.itheima.service.impl;

import com.itheima.mapper.UserMapper;
import com.itheima.model.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User user1 = userMapper.findByUsernameAndPassword(user);
        return user1;
    }
}
