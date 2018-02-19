package com.alican.service;

import com.alican.models.Applicant;
import com.alican.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("applicantService")
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Applicant findApplicantByMail(String mail) {
        return applicantRepository.findByMail(mail);
    }

    @Override
    public int Add(Applicant applicant) {
        return applicantRepository.save(applicant).getId();
    }

    @Override
    public List<Applicant> find() {
        return applicantRepository.findAll();
    }


}
