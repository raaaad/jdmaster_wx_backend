package com.smartbackend.service;

import com.smartbackend.model.Resume;

import java.util.List;

public interface IResumeService {
    public List<Resume> getResumes(Integer jobId);

    public Resume getResumeById(Integer id);
}
