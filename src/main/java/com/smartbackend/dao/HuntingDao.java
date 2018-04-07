package com.smartbackend.dao;

import com.smartbackend.model.Hunting;
import org.apache.ibatis.annotations.Param;

public interface HuntingDao {
    Hunting getHunting(@Param("wechat")String wechat,@Param("jobId")Integer jobId);

    void addView(@Param("wechat")String wechat,@Param("jobId")Integer jobId);

    void changeFollow(@Param("wechat")String wechat,@Param("jobId")Integer jobId,@Param("status")Integer status);

    void sendResume(@Param("wechat")String wechat,@Param("jobId")Integer jobId,@Param("resumeId")Integer resumeId);

}
