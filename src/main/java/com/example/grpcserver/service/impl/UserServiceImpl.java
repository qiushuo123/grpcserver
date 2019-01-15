package com.example.grpcserver.service.impl;

import com.example.grpcserver.dao.UserDao;
import com.example.grpcserver.domain.User;
import com.example.grpcserver.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    @Override
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void updateUsername(int userId, String username, int age){
        userDao.updateUsername(userId,username,age);
    }
}
