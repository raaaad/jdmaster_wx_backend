package com.smartbackend.service;

import com.smartbackend.model.User;

public interface IUserService {
    public User getUserById(int id);

    public User getUserByWechat(String wechat);

    public void addUser(String wechat,String nickname);
}
