package com.alican.repository;

import com.alican.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("jobRepository")
public interface JobRepository extends JpaRepository<Job, Integer> {

}
