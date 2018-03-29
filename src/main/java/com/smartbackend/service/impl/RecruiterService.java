package com.smartbackend.service.impl;

import com.smartbackend.dao.RecruiterDao;
import com.smartbackend.service.IRecruiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("recruiterService")
public class RecruiterService implements IRecruiterService {
    @Resource
    private RecruiterDao recruiterDao;

    @Override
    public void insertRecruiter(String company, String telephone, String email, String wechat) {
        recruiterDao.insertRecruiter(company,telephone,email,wechat);
    }
}
