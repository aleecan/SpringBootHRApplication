package com.alican.controller;

import com.alican.models.Job;
import com.alican.models.Role;
import com.alican.models.User;
import com.alican.repository.UserRepository;
import com.alican.service.JobService;
import com.alican.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @RequestMapping(value={"/" , "/home"}, method = RequestMethod.GET)
    public ModelAndView jobList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Job> jobList = jobService.findAll();
        modelAndView.addObject("jobs", jobList);
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
