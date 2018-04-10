package com.smartbackend.service.impl;

import com.smartbackend.dao.RecruiterDao;
import com.smartbackend.model.Recruiter;
import com.smartbackend.service.IRecruiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("recruiterService")
public class RecruiterService implements IRecruiterService {
    @Resource
    private RecruiterDao recruiterDao;

    @Override
    public void insertRecruiter(String company, String telephone, String email, String wechat,String headpic,String nickname) {
        recruiterDao.insertRecruiter(company,telephone,email,wechat,headpic,nickname);
    }

    @Override
    public Recruiter getRecruiterByWechat(String wechat){
        return recruiterDao.getRecruiterByWechat(wechat);
    }

    @Override
    public List<Recruiter> getRecruiters(){
        return this.recruiterDao.getRecruiters();
    }

    @Override
    public void updatePic(String wechat,String headpic,String nickname){
        this.recruiterDao.updatePic(wechat,headpic,nickname);
    }
}
