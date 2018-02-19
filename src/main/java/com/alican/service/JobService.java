package com.alican.service;

import com.alican.models.Job;

import java.util.List;

public interface JobService {
    public List<Job> findAll();
    public Job findById(int id);
    public Job add(Job job);

}
