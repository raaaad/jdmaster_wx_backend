package com.smartbackend.dao;

import com.smartbackend.model.Resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResumeDao {
    List<Resume> getResumes(@Param("jobid")Integer jobId);

    Resume getResumeById(@Param("id")Integer id);
}
