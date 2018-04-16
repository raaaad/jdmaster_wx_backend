package com.smartbackend.service.impl;

import com.smartbackend.dao.UserDao;
import com.smartbackend.model.User;
import com.smartbackend.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService implements IUserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(int id){
        return this.userDao.getUserById(id);
    }

    @Override
    public User getUserByWechat(String wechat){
        return this.userDao.getUserByWechat(wechat);
    }

    @Override
    public void addUser(String wechat,String nickname){
        this.userDao.addUser(wechat,nickname);
    }
}
