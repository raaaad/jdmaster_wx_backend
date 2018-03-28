package com.smartbackend.service;

import com.smartbackend.model.Trainee;

import java.util.List;

public interface ITraineeService {
    public List<Trainee> getAllTrainees();
    public Trainee getTraineeById(int id);
}
