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
                    @Param("startwork")String startwork,@Param("email")String email);
    Trainee getTraineeByWechat(@Param("wechat")String wechat);
}
