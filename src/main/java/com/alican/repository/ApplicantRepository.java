package com.alican.repository;

import com.alican.models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("applicantRepository")
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    Applicant findByMail(String mail);
}
