package com.smartbackend.dao;

import com.smartbackend.model.Recruiter;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;

import javax.annotation.PreDestroy;
import java.util.List;

public interface RecruiterDao {
    void insertRecruiter(@Param("company")String company, @Param("telephone")String telephone,@Param("email")String email,
                         @Param("wechat")String wechat,@Param("headpic")String headpic,@Param("nickname")String nickname);

    Recruiter getRecruiterByWechat(@Param("wechat")String wechat);

    List<Recruiter> getRecruiters();

    void updatePic(@Param("wechat")String wechat,@Param("headpic")String headpic,@Param("nickname")String nickname);

    void deleteRecruiter(@Param("wechat")String wechat);

    void deleteJob(@Param("wechat")String wechat);
}
