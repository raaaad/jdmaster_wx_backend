package com.smartbackend.dao;

import com.smartbackend.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User getUserById(Integer id);

    User getUserByWechat(@Param("wechat")String wechat);

    void addUser(@Param("wechat")String wechat,@Param("nickname")String nickname);
}
