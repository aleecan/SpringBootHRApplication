package com.alican.repository;

import com.alican.models.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jobApplicantRepository")
public interface JobApplicantRepository extends JpaRepository<JobApplicant , Integer> {
}
