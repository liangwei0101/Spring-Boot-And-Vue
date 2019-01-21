package com.liangwei.demo.service.impl;

import java.util.List;
import com.liangwei.demo.mapper.UserMapper;
import com.liangwei.demo.model.User;
import com.liangwei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void AddUser(User user) {
        userMapper.AddUser(user);
    }

    @Override
    public void delUserById(int no) {
        userMapper.delUserById(no);
    }

    @Override
    public User updateUserById(User user) {
        return userMapper.updateUserById(user.getNo(),user.getName(),user.getEmail());
    }

    @Override
    public List<User> getUser() {
        return userMapper.getUser();
    }
}
