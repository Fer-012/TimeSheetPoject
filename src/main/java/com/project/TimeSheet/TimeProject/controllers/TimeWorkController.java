package com.project.TimeSheet.TimeProject.controllers;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.TimeSheet.TimeProject.models.IntermediaireProjectModel;
import com.project.TimeSheet.TimeProject.models.Projects;
import com.project.TimeSheet.TimeProject.models.TimeWork;
import com.project.TimeSheet.TimeProject.repositories.ProjectRepository;
import com.project.TimeSheet.TimeProject.repositories.TimeWorkRepository;
import com.project.TimeSheet.TimeProject.services.TimeWorkService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("api/timeworkController/")
@CrossOrigin(origins="*", maxAge=4800)
@RestController
public class TimeWorkController {
	@Autowired
	public TimeWorkService timeWorkService;

	@Autowired
	public ProjectRepository projectRepo;

	@Autowired
	public TimeWorkRepository timeWorkRepo;
	
	@GetMapping("get_timework")
	public List<TimeWork> getAllTimeWork(){
		return timeWorkService.getAllTimeWork();
	}
	
	@GetMapping("{id}")
	public TimeWork getTimeWorkById(@PathVariable Long id) {
		return timeWorkService.getTimeWorkById(id);
	}
	
	@DeleteMapping("deleteTimeWorkById/{id}")
	public void deleteTimeWorkById(@PathVariable Long id) {
		timeWorkService.deleteTimeWorkById(id);
	}
	
	// @PostMapping("add_timework") 
	// public TimeWork addTimeWork(@RequestBody TimeWork t) {
	// 	System.out.println("test TimeWork request "+ t);
	// 	return timeWorkService.addTimeWork(t);
	// }

	@PostMapping("add_timework") 
	public void addTimeWork(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException {
		try {

			String workHours = request.getParameter("workHours");
			String displayTime = request.getParameter("displayTime");
			String hourStart = request.getParameter("hourStart");
			String currentTime = request.getParameter("currentTime");
			String dateDuJour = request.getParameter("dateDuJour");
			String note = request.getParameter("note");

			Long projectId = Long.parseLong(request.getParameter("idproject"));

			TimeWork timeWork = new TimeWork();

			timeWork.setWorkHours(workHours);
			timeWork.setDisplayTime(displayTime);
			timeWork.setHourStart(hourStart);
			timeWork.setCurrentTime(currentTime);
			timeWork.setDateDuJour(dateDuJour);
			timeWork.setNote(note);


			try {

				projectRepo.findById(projectId).ifPresent(timeWork::setIdproject);
				timeWorkRepo.save(timeWork);
				Map<String, String> map = new HashMap<>();

				map.put("messsage", "created with success");

				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("application/json");

				new ObjectMapper().writeValue(response.getOutputStream(), map);
				

			} catch (Exception e){
				Map<String, String> map = new HashMap<>();
				map.put("messsage", "Project not found");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response.setContentType("application/json");

				new ObjectMapper().writeValue(response.getOutputStream(), map);
			}






		} catch (Exception e){
			System.out.println(e);
				Map<String, String> map = new HashMap<>();
				map.put("messsage", e.getMessage());
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.setContentType("application/json");

				new ObjectMapper().writeValue(response.getOutputStream(), map);
		}
	}
	

	@GetMapping("get_timesheets_admin")
	public List<IntermediaireProjectModel> getTimeSheetsAdmin(HttpServletRequest request, HttpServletResponse response){

		try {

			List<Projects> projects = projectRepo.findSentToAdminProjects();
			
			List<IntermediaireProjectModel> listOfProjects = new ArrayList<IntermediaireProjectModel>();
			for (Projects p : projects){
				List<TimeWork> timeWorks = timeWorkRepo.findAll();

				List<TimeWork> speceficProjectTimeWorks = new ArrayList<TimeWork>();

				for(TimeWork t : timeWorks){

					if(t.getIdproject() != null && t.getIdproject().getId() == p.getId()){
						speceficProjectTimeWorks.add(t);
					}

				}



				IntermediaireProjectModel interP = new IntermediaireProjectModel(
					p, speceficProjectTimeWorks
				);

				listOfProjects.add(interP);


			}
			
			return listOfProjects;

		} catch (Exception e){
			log.error("error : ", e);
		}
		return null;

	}

	@PutMapping
	public TimeWork editTimeWork(@PathVariable TimeWork t) {
		return timeWorkService.updateTimeWork(t);
	}
	
	

}
