package com.smartbackend.dao;

import com.smartbackend.model.Hunting;
import com.smartbackend.utils.HuntingListIO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HuntingDao {
    Hunting getHunting(@Param("wechat")String wechat,@Param("jobId")Integer jobId);

    void addView(@Param("wechat")String wechat,@Param("jobId")Integer jobId);

    void changeFollow(@Param("wechat")String wechat,@Param("jobId")Integer jobId,@Param("status")Integer status);

    void sendResume(@Param("wechat")String wechat,@Param("jobId")Integer jobId,@Param("resumeId")Integer resumeId);

    void addFeedback(@Param("wechat")String wechat,@Param("jobId")Integer jobId,@Param("feedback")Integer feedback);

    List<HuntingListIO> getTraineeInfoByHRWeChat(@Param("wechat")String wechat);
}
