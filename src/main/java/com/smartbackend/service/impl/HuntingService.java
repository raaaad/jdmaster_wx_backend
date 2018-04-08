package com.smartbackend.service.impl;

import com.smartbackend.dao.HuntingDao;
import com.smartbackend.model.Hunting;
import com.smartbackend.service.IHuntingService;
import com.smartbackend.utils.ObjectUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("huntingService")
public class HuntingService implements IHuntingService{
    @Resource
    private HuntingDao huntingDao;

    @Override
    public Integer addView(String wechat,Integer jobId){
        if(ObjectUtil.isNullOrEmpty(this.huntingDao.getHunting(wechat,jobId))){
            this.huntingDao.addView(wechat,jobId);
            return 1;
        }
        return 0;
    }

    @Override
    public void changeFollow(String wechat,Integer jobId,Integer status){
        this.huntingDao.changeFollow(wechat,jobId,status);
    }

    @Override
    public void sendResume(String wechat,Integer jobId,Integer resumeId){
        this.huntingDao.sendResume(wechat,jobId,resumeId);
    }

    @Override
    public void addFeedback(String wechat,Integer jobId,Integer feedback){
        this.huntingDao.addFeedback(wechat,jobId,feedback);
    }

    @Override
    public Hunting getHunting(String wechat,Integer jobId){
       return this.huntingDao.getHunting(wechat,jobId);
    }
}
