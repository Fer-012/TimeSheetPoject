package com.project.TimeSheet.TimeProject.services;

import java.util.List;

import com.project.TimeSheet.TimeProject.models.Projects;

public interface ProjectService {

	public List<Projects> getAllProjects();
	
	public Projects getProjectById(Long id);
	
	public Projects addProject(Projects p);
	
	public Projects updateProject(Projects p);
	
	public void deleteProjectById(Long id);
}
