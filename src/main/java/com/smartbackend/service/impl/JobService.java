package com.smartbackend.service.impl;

import com.smartbackend.dao.JobDao;
import com.smartbackend.model.Job;
import com.smartbackend.service.IJobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("jobService")
public class JobService implements IJobService {
    @Resource
    private JobDao jobDao;

    @Override
    public void addJob(String company, String position, Integer workDayPerWeek,Integer minSalary, Integer maxSalary,String address,
                       String education, String major, Integer recruitNumber,Integer monthForWork, Integer correction,String endTime,
                       String description,String hrPosition, String recruiterWechat,String picture){
        this.jobDao.addJob(company,position,workDayPerWeek,minSalary,maxSalary,address,education,major,recruitNumber,monthForWork,
                 correction,endTime,description,hrPosition,recruiterWechat,picture);
    }

    @Override
    public Job getJobById(Integer id){
        return this.jobDao.getJobById(id);
    }

    @Override
    public List<Job> getJobs(){
        return this.jobDao.getJobs();
    }
}
