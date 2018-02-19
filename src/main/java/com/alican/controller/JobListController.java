package com.alican.controller;

import com.alican.models.Applicant;
import com.alican.models.Job;
import com.alican.models.Role;
import com.alican.models.User;
import com.alican.service.ApplicantService;
import com.alican.service.JobService;
import com.alican.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class JobListController {
    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicantService applicantService;


    @RequestMapping(value="/joblist", method = RequestMethod.GET)
    public ModelAndView jobList(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userN", user.getName() + " " + user.getLastName());
        Set<Role> role = user.getRoles();
        modelAndView.addObject("role", role);
        List<Job> jobList = jobService.findAll();
        modelAndView.addObject("jobs", jobList);
        modelAndView.setViewName("jobList");
        return modelAndView;
    }
    @RequestMapping(value="/joblist/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        List<Applicant> appList = applicantService.find();
        Job detail = jobService.findById(id);
        modelAndView.addObject("url", id);
        modelAndView.addObject("detail", detail.getJobTitle());
        modelAndView.addObject("applicant", appList);
        modelAndView.setViewName("detail");
        return modelAndView;
    }
    @RequestMapping(value="/joblist/detail1/{id}", method = RequestMethod.GET)
    public ModelAndView detail1(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Job detail = new Job();
        detail = jobService.findById(id);
        System.out.println(detail);
        modelAndView.addObject("detail", detail);
        modelAndView.setViewName("apply");
        return modelAndView;
    }
    @RequestMapping(value="/joblist/add", method = RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        Job job = new Job();
        modelAndView.addObject("job" , job);
        modelAndView.setViewName("addJob");
        return modelAndView;
    }
    @RequestMapping(value="/joblist/add/ok", method = RequestMethod.POST)
    public ModelAndView addOk(@Valid Job job , BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userN", user.getName() + " " + user.getLastName());
        jobService.add(job);
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping(value = "/applyApplication" , method = RequestMethod.POST)
    public Job addJob(){
        Job jb = new Job();
        jb.setId(1);
        return jb;
    }
}
