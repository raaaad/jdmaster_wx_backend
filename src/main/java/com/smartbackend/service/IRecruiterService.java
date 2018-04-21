package com.smartbackend.service;

import com.smartbackend.model.Recruiter;
import com.smartbackend.utils.Resp;

import java.util.List;

public interface IRecruiterService {
    public void insertRecruiter(String company,String telephone,String email,String wechat,String headpic,String nickname);

    public Recruiter getRecruiterByWechat(String wechat);

    public List<Recruiter> getRecruiters();

    public void updatePic(String wechat, String headpic,String nickname);

    public void deleteRecruiter(String wechat);

    public Resp modifyInfo(String company,String phone,String email,String wechat);
}
