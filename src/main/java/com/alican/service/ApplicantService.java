package com.alican.service;

import com.alican.models.Applicant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantService {
    public Applicant findApplicantByMail(String mail);
    public int Add(Applicant applicant);
    public List<Applicant> find();
}
