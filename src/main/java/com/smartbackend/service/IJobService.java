package com.smartbackend.service;

import com.smartbackend.model.Job;
import jdk.nashorn.internal.scripts.JO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IJobService {
    public void addJob(String company, String position, Integer workDayPerWeek,Integer minSalary, Integer maxSalary,String address,
                String education, String major, Integer recruitNumber,Integer monthForWork, Integer correction,String endTime,
                String description,String hrPosition, String recruiterWechat,String picture,Integer status);

    public Job getJobById(Integer id);

    public List<Job> getJobs();

    public List<Job> getMyJobs(String wechat);

    public List<Job> getMyJobByStatus(String wechat,Integer status);

    public void changeJobStatus(Integer id,Integer status);

    public List<Job> getJobsByStatus(String status,String wechat);
}
