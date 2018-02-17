package com.alican.service;

import com.alican.models.Applicant;

public interface ApplicantService {
    public Applicant findApplicantByMail(String mail);
    public int Add(Applicant applicant);
}
