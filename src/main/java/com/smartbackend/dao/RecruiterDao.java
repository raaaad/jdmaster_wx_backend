package com.smartbackend.dao;

import org.apache.ibatis.annotations.Param;

public interface RecruiterDao {
    void insertRecruiter(@Param("company")String company, @Param("telephone")String telephone,@Param("email")String email,@Param("wechat")String wechat);
}
