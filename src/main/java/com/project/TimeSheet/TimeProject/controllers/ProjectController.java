package com.project.TimeSheet.TimeProject.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.TimeSheet.TimeProject.models.Projects;
import com.project.TimeSheet.TimeProject.repositories.ProjectRepository;
import com.project.TimeSheet.TimeProject.repositories.UserRepository;
import com.project.TimeSheet.TimeProject.services.ProjectService;
import com.project.TimeSheet.TimeProject.services.UsersCRUDService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;

@RequestMapping("api/projectController/")
@CrossOrigin(origins="*", maxAge=4800)
@RestController
public class ProjectController {

	@Autowired
	public ProjectService projectService;

	@Autowired
	public UsersCRUDService userService;
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public ProjectRepository projectRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class) ;

	
	@GetMapping("get_project")
	public List<Projects> getAllProjects() {
		return projectService.getAllProjects();
	}

	@GetMapping("{id}")
	public Projects getProjectsById(@PathVariable Long id) {
		return projectService.getProjectById(id);
	}

	@DeleteMapping("{id}")
	public void deleteProjectById(@PathVariable Long id) {
		projectService.deleteProjectById(id);
	}

	// @PostMapping("add_project")
	// public Projects addProjects(@RequestBody Projects project) {
	// 	System.out.println("test project request "+ project);
	// 	return projectService.addProject(project);
	// }


	@PostMapping("add_project")
	public void addProjects(HttpServletRequest request, HttpServletResponse response)
		throws ParseException, StreamWriteException, DatabindException, IOException
		{
		// System.out.println("test project request "+ project);
		// return projectService.addProject(project);

		try {
			String title = request.getParameter("title");
			String client = request.getParameter("client");
			String description = request.getParameter("description");

			String dateStart = request.getParameter("dateStart");
			String dateEnd = request.getParameter("dateEnd");
			logger.info(request.getParameter("idConsultant"));

			Long idConsultant = Long.parseLong(request.getParameter("idConsultant"));

			Projects project = new Projects();
			project.setTitle(title);
			project.setClient(client);
			project.setDescription(description);
			project.setDateStart(dateStart);
			project.setDateEnd(dateEnd);

			try {
				userRepo.findById(idConsultant).ifPresent(project::setIdConsultant);
				projectRepo.save(project);
				Map<String, String> map = new HashMap<>();

				map.put("messsage", "created with success");

				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("application/json");

				new ObjectMapper().writeValue(response.getOutputStream(), map);


			} catch(Exception e){
				logger.error(e.getMessage());
				Map<String, String> map = new HashMap<>();
				map.put("messsage", "user not found");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response.setContentType("application/json");

				new ObjectMapper().writeValue(response.getOutputStream(), map);
			}

			logger.info(title);
		} catch (Exception e){
			System.out.println(e);
				Map<String, String> map = new HashMap<>();
				map.put("messsage", e.getMessage());
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.setContentType("application/json");

				new ObjectMapper().writeValue(response.getOutputStream(), map);
		}
	}
	
	@PostMapping("send_worksheet")
	public void sendWorkSheet(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException {
		
			try {
				Long projectId = Long.parseLong(request.getParameter("projectId"));


				try {
					Optional<Projects> projectOpt = projectRepo.findById(projectId);
					Projects project = projectOpt.get();
					project.setShown(true);
					projectRepo.save(project);
					Map<String, String> map = new HashMap<>();

					map.put("messsage", "shown status updated with success");

					response.setStatus(HttpServletResponse.SC_OK);
					response.setContentType("application/json");

					new ObjectMapper().writeValue(response.getOutputStream(), map);

				} catch(Exception e){
					logger.error(e.getMessage());
					Map<String, String> map = new HashMap<>();
					map.put("messsage", "user not found");
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
					response.setContentType("application/json");

					new ObjectMapper().writeValue(response.getOutputStream(), map);
				}
				


			} catch(Exception e){
				Map<String, String> map = new HashMap<>();
				map.put("messsage", e.getMessage());
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.setContentType("application/json");

				new ObjectMapper().writeValue(response.getOutputStream(), map);
			}
		
	}


	@PostMapping("accept_or_decline_worksheet")
	public void acceptOrDeclineWorksheet(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException {
		
			try {
				Long projectId = Long.parseLong(request.getParameter("projectId"));
				Boolean decision = Boolean.parseBoolean(request.getParameter("decision"));


				try {
					Optional<Projects> projectOpt = projectRepo.findById(projectId);
					Projects project = projectOpt.get();
					project.setAdminDecision(decision);
					projectRepo.save(project);
					Map<String, String> map = new HashMap<>();

					map.put("messsage", "decision updated with success");

					response.setStatus(HttpServletResponse.SC_OK);
					response.setContentType("application/json");

					new ObjectMapper().writeValue(response.getOutputStream(), map);

				} catch(Exception e){
					logger.error(e.getMessage());
					Map<String, String> map = new HashMap<>();
					map.put("messsage", "user not found");
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
					response.setContentType("application/json");

					new ObjectMapper().writeValue(response.getOutputStream(), map);
				}
				


			} catch(Exception e){
				Map<String, String> map = new HashMap<>();
				map.put("messsage", e.getMessage());
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.setContentType("application/json");

				new ObjectMapper().writeValue(response.getOutputStream(), map);
			}
		
	}
	
	@GetMapping("admin_get_sent_time_sheets")
	public void adminProjectsWithTheirTimeSheets(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException{

		try {

			

		} catch(Exception e){

			Map<String, String> map = new HashMap<>();
			map.put("messsage", e.getMessage());
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType("application/json");

			new ObjectMapper().writeValue(response.getOutputStream(), map);

		}

	}


	@PutMapping
	public Projects editProject(@RequestBody Projects p) {
		return projectService.updateProject(p);
	}
	@CrossOrigin(origins="*", maxAge=4800)
	@GetMapping(value = "test", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String test() {

		return "test ";
	}

}
