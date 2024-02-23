package com.project.TimeSheet.TimeProject.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TimeSheet.TimeProject.models.Projects;
import com.project.TimeSheet.TimeProject.repositories.ProjectRepository;
import com.project.TimeSheet.TimeProject.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository ;
	@Override
	public List<Projects> getAllProjects() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public Projects getProjectById(Long id) {
		// TODO Auto-generated method stub
		Optional<Projects> project = projectRepository.findById(id);
		return project.isPresent()? project.get() : null;
	}

	@Override
	public Projects addProject(Projects project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}

	@Override
	public Projects updateProject(Projects project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}

	@Override
	public void deleteProjectById(Long id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

}
