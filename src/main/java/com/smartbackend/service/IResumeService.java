package com.smartbackend.service;

import com.smartbackend.model.Resume;

import java.util.List;

public interface IResumeService {
    public List<Resume> getResumes(Integer jobId);

    public Resume getResumeById(Integer id);

    public void deleteCurResume(String wechat);

    public void addResume(String wechat,String url,Integer current);

    public Integer getCurResume(String wechat);

    public Integer getResumeIdByUrl(String url);
}
