package com.project.TimeSheet.TimeProject.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.TimeSheet.TimeProject.repositories.ProjectRepository;
import com.project.TimeSheet.TimeProject.repositories.TimeWorkRepository;
import com.project.TimeSheet.TimeProject.repositories.UserRepository;

@RequestMapping("/api/stats/")
@CrossOrigin(origins="*", maxAge=4800)
@RestController
public class StatsController {

    @Autowired 
    public ProjectRepository projectRepo;

    @Autowired
    public UserRepository userRepo;

    @Autowired
    public TimeWorkRepository timeWorkRepository;

    @GetMapping("statics")
    public void getStatics(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException {
        
        try {

            long userCount = userRepo.count();
            long totalProjects = projectRepo.count();
            long inProgressProjects = projectRepo.count(false);
            long completedProjects = projectRepo.count(true);

            long consultantsCount = userRepo.countConsultant();
            long countClients = userRepo.countClients();
            List<Map<String, Integer>> countsByDayTime = timeWorkRepository.countByDay();




            Map<String, Object> statics = new HashMap<>();
            statics.put("userCount", userCount);
            statics.put("totalProjects", totalProjects);
            statics.put("inProgressProjects", inProgressProjects);
            statics.put("completedProjects", completedProjects);
            statics.put("consultantsCount", consultantsCount);
            statics.put("countClients", countClients);
            statics.put("countsByDayTime", countsByDayTime);


            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getOutputStream(), statics);

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getOutputStream(), error);
        }
        
    }
    




    
    

}
