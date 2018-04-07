package com.smartbackend.dao;

import com.smartbackend.model.Resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResumeDao {
    List<Resume> getResumes(@Param("jobid")Integer jobId);

    Resume getResumeById(@Param("id")Integer id);

    void deleteCurResume(@Param("wechat")String wechat);

    void addResume(@Param("wechat")String wechat,@Param("url")String url,@Param("current")Integer current);

    Integer getCurResume(@Param("wechat")String wechat);

    Integer getResumeIdByUrl(@Param("url")String url);
}
