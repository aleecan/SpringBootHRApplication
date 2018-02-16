package com.alican.service;

import com.alican.models.Job;
import com.alican.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("jobService")
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
}
