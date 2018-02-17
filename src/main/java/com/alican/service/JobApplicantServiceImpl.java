package com.alican.service;

import com.alican.models.JobApplicant;
import com.alican.repository.JobApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobApplicantServiceImpl implements JobApplicantService{
    @Autowired
    private JobApplicantRepository jobApplicantRepository;
    @Override
    public void Add(JobApplicant jobApplicant) {
         jobApplicantRepository.save(jobApplicant);
    }
}
