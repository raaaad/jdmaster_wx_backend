package com.smartbackend.service;

import com.smartbackend.model.Trainee;

import java.util.List;

public interface ITraineeService {
    public List<Trainee> getAllTrainees();
    public Trainee getTraineeById(int id);
    public void addTrainee(String name,String gender,String school,String telephone,String major,String minor,
                          String wechat,Integer workdayperweek,String startwork,String email,String education,String graduateTime,String headpic,String nickname);
    public Trainee getTraineeByWechat(String wechat);
    public List<Trainee> getFollowList(Integer jobId);
    public List<Trainee> getViewList(Integer jobId);
    public void updatePic(String wechat, String headpic,String nickname);
}
