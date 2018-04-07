package com.smartbackend.service.impl;

import com.smartbackend.dao.ResumeDao;
import com.smartbackend.model.Resume;
import com.smartbackend.service.IResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("resumeService")
public class ResumeService implements IResumeService {
    @Resource
    private ResumeDao resumeDao;

    @Override
    public List<Resume> getResumes(Integer jobId){
        return this.resumeDao.getResumes(jobId);
    }

    @Override
    public Resume getResumeById(Integer id){
        return this.resumeDao.getResumeById(id);
    }

    @Override
    public void deleteCurResume(String wechat){
        this.resumeDao.deleteCurResume(wechat);
    }

    @Override
    public void addResume(String wechat,String url,Integer current){
        this.resumeDao.addResume(wechat,url,current);
    }

    @Override
    public Integer getCurResume(String wechat){
       return this.resumeDao.getCurResume(wechat);
    }

    @Override
    public Integer getResumeIdByUrl(String url){
       return  this.resumeDao.getResumeIdByUrl(url);
    }
}
