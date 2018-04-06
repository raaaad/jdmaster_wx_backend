package com.smartbackend.dao;

import com.smartbackend.model.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface JobDao {
    void addJob(@Param("company")String company, @Param("position")String position, @Param("workDayPerWeek")Integer workDayPerWeek,
                   @Param("minSalary")Integer minSalary, @Param("maxSalary")Integer maxSalary, @Param("address")String address,
                   @Param("education")String education, @Param("major")String major, @Param("recruitNumber")Integer recruitNumber,
                   @Param("monthForWork")Integer monthForWork, @Param("correction")Integer correction, @Param("endTime")String endTime,
                   @Param("description")String description,@Param("hrPosition")String hrPosition,@Param("recruiterWechat")String recruiterWechat,
                   @Param("picture")String picture);

    Job getJobById(@Param("id")Integer id);

    List<Job> getJobs();

    List<Job> getMyJobs(@Param("wechat")String wechat);

    List<Job> getMyJobByStatus(@Param("wechat")String wechat,@Param("status")Integer status);

    void changeJobStatus(@Param("id")Integer id,@Param("status")Integer status);

    List<Job> getJobsViewd(@Param("wechat")String wechat);

    List<Job> getJobsFollowed(@Param("wechat")String wechat);

    List<Job> getJobsDeliveried(@Param("wechat")String wechat);
}
