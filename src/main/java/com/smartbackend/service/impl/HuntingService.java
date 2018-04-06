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

}
