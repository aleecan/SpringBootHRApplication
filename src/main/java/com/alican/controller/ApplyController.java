package com.alican.controller;

import com.alican.models.Applicant;
import com.alican.models.Job;
import com.alican.service.ApplicantService;
import com.alican.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/applicant")
public class ApplyController{
    @Autowired
    private JobService jobService;
    @Autowired
    private ApplicantService applicantService;
    public int jobId;

    @RequestMapping(value = "/apply/{id}" , method = RequestMethod.GET)
    public ModelAndView apply(@PathVariable("id") int id ){
        Job detail = jobService.findById(id);
        jobId = id;
        System.out.println(jobId);
        ModelAndView modelAndView = new ModelAndView();
        Applicant applicant = new Applicant();
        modelAndView.addObject("applicant", applicant);
        modelAndView.addObject("detail", detail.getJobDescription());
        modelAndView.setViewName("apply");
        System.out.println(applicant.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/apply" , method = RequestMethod.POST)
    public ModelAndView apply1(@Valid Applicant applicant , BindingResult bindingResult ){
        System.out.println("After Applied" + jobId);
        ModelAndView modelAndView = new ModelAndView();
        Job detail = jobService.findById(jobId);
        applicant.setJob(detail);
        /*Applicant userExists = applicantService.findApplicantByMail(applicant.getMail());
        if (userExists != null) {
            System.out.println("Kullanıcı Kaydedildi");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("home");
        }
        else {*/
            modelAndView.addObject("successMessage", "User has been registered successfully");
            List<Job> jobList = jobService.findAll();
            modelAndView.addObject("jobs", jobList);
            modelAndView.setViewName("home");
            int appId = applicantService.Add(applicant);



        //}
        return modelAndView;
    }
}
