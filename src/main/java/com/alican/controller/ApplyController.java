package com.alican.controller;

import com.alican.models.Applicant;
import com.alican.models.Job;
import com.alican.service.ApplicantService;
import com.alican.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/applicant")
public class ApplyController{

    @Autowired
    private JobService jobService;
    @Autowired
    private ApplicantService applicantService;
    public int jobId;

    private static String UPLOADED_FOLDER = "/Users/alican/Desktop/HRApp/src/main/resources/static/images/";

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
    public ModelAndView apply1(@Valid Applicant applicant , BindingResult bindingResult,@RequestParam("file") MultipartFile file,
                               RedirectAttributes redirectAttributes ) throws IOException{
        System.out.println("After Applied" + jobId);
        ModelAndView modelAndView = new ModelAndView();
        Job detail = jobService.findById(jobId);
        System.out.println(""+applicant.getResumePath());
        applicant.setJob(detail);
        modelAndView.addObject("successMessage", "User has been registered successfully");
        List<Job> jobList = jobService.findAll();
        modelAndView.addObject("jobs", jobList);
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            applicant.setResumePath(file.getOriginalFilename());

            int appId = applicantService.Add(applicant);
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
