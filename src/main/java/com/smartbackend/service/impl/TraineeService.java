package com.smartbackend.service.impl;

import com.smartbackend.dao.TraineeDao;
import com.smartbackend.model.Trainee;
import com.smartbackend.service.ITraineeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("traineeService")
public class TraineeService implements ITraineeService{
    @Resource
    private TraineeDao traineeDao;

    @Override
    public List<Trainee> getAllTrainees(){
        return traineeDao.getAllTrainees();
    }

    @Override
    public Trainee getTraineeById(int id){
        return traineeDao.getTraineeById(id);
    }

    @Override
    public void addTrainee(String name,String gender,String school,String telephone,String major,String minor,
                           String wechat,Integer workdayperweek,String startwork,String email,String education,String graduateTime,String headpic,String nickname){
        traineeDao.addTrainee(name,gender,school,telephone,major,minor,wechat,workdayperweek,startwork,email,education,graduateTime,headpic,nickname);
    }

    @Override
    public Trainee getTraineeByWechat(String wechat){
        return traineeDao.getTraineeByWechat(wechat);
    }

    @Override
    public List<Trainee> getViewList(Integer jobId){
        return this.traineeDao.getViewList(jobId);
    }

    @Override
    public List<Trainee> getFollowList(Integer jobId){
        return this.traineeDao.getFollowList(jobId);
    }

    @Override
    public void updatePic(String wechat,String headpic,String nickname){
        this.traineeDao.updatePic(wechat,headpic,nickname);
    }

    @Override
    public void deleteTrainee(String wechat){
        this.traineeDao.deleteHunting(wechat);
        this.traineeDao.deleteResume(wechat);
        this.traineeDao.deleteTrainee(wechat);
    }
}
