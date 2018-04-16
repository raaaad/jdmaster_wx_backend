package com.smartbackend.dao;

import com.smartbackend.model.Trainee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TraineeDao {
    List<Trainee> getAllTrainees();
    Trainee getTraineeById(int id);
    void addTrainee(@Param("name")String name,@Param("gender")String gender,@Param("school")String school,
                    @Param("telephone")String telephone,@Param("major")String major,@Param("minor")String minor,
                    @Param("wechat")String wechat,@Param("workdayperweek")Integer workdayperweek,
                    @Param("startwork")String startwork,@Param("email")String email,@Param("education")String education,
                    @Param("graduateTime")String graduateTime,@Param("headpic")String headpic,@Param("nickname")String nickname);
    Trainee getTraineeByWechat(@Param("wechat")String wechat);
    List<Trainee> getViewList(@Param("jobId")Integer jobId);
    List<Trainee> getFollowList(@Param("jobId")Integer jobId);
    void updatePic(@Param("wechat")String wechat,@Param("headpic")String headpic,@Param("nickname")String nickname);
    void deleteTrainee(@Param("wechat")String wechat);
    void deleteHunting(@Param("wechat")String wechat);
    void deleteResume(@Param("wechat")String wechat);
}
