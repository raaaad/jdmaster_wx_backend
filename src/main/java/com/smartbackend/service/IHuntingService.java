package com.smartbackend.service;

import com.smartbackend.model.Hunting;
import com.smartbackend.utils.HuntingListIO;

import java.util.List;

public interface IHuntingService {
    public Integer addView(String wechat,Integer jobId);

    public void changeFollow(String wechat,Integer jobId,Integer status);

    public void sendResume(String wechat,Integer jobId,Integer resumeId);

    public void addFeedback(String wechat,Integer jobId,Integer feedback);

    public Hunting getHunting(String wechat,Integer jobId);

    public List<HuntingListIO> getTraineeInfoByHRWeChat(String wechat);
}
