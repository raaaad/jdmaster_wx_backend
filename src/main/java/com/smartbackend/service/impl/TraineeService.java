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
}
