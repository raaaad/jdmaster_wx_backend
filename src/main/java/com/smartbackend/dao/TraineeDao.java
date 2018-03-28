package com.smartbackend.dao;

import com.smartbackend.model.Trainee;

import java.util.List;

public interface TraineeDao {
    List<Trainee> getAllTrainees();
    Trainee getTraineeById(int id);
}
