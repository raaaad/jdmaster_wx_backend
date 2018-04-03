package com.smartbackend.service;

import com.smartbackend.model.Job;

import java.util.List;

public interface IJobService {
    public void addJob(String company, String position, Integer workDayPerWeek,Integer minSalary, Integer maxSalary,String address,
                String education, String major, Integer recruitNumber,Integer monthForWork, Integer correction,String endTime,
                String description,String hrPosition, String recruiterWechat,String picture);

    public Job getJobById(Integer id);

    public List<Job> getJobs();
}
