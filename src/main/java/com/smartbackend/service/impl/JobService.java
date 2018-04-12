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
                       String description,String hrPosition, String recruiterWechat,String picture,Integer status){
        this.jobDao.addJob(company,position,workDayPerWeek,minSalary,maxSalary,address,education,major,recruitNumber,monthForWork,
                 correction,endTime,description,hrPosition,recruiterWechat,picture,status);
    }

    @Override
    public Job getJobById(Integer id){
        return this.jobDao.getJobById(id);
    }

    @Override
    public List<Job> getJobs(){
        return this.jobDao.getJobs();
    }

    @Override
    public List<Job> getMyJobs(String wechat){
        return this.jobDao.getMyJobs(wechat);
    }

    @Override
    public void changeJobStatus(Integer id,Integer status){
        this.jobDao.changeJobStatus(id,status);
    }

    @Override
    public List<Job> getMyJobByStatus(String wechat,Integer status){
        return this.jobDao.getMyJobByStatus(wechat,status);
    }

    @Override
    public List<Job> getJobsByStatus(String status,String wechat){
        if("view".equals(status)) {
            return this.jobDao.getJobsViewd(wechat);
        } else if ("follow".equals(status)) {
            return this.jobDao.getJobsFollowed(wechat);
        } else if("delivery".equals(status)){
            return this.jobDao.getJobsDeliveried(wechat);
        }else{
            return this.jobDao.getJobs();
        }
    }

}
