package com.smartbackend.dao;

import com.smartbackend.model.Recruiter;
import org.apache.ibatis.annotations.Param;

import javax.annotation.PreDestroy;

public interface RecruiterDao {
    void insertRecruiter(@Param("company")String company, @Param("telephone")String telephone,@Param("email")String email,@Param("wechat")String wechat);

    Recruiter getRecruiterByWechat(@Param("wechat")String wechat);
}
