package com.project.TimeSheet.TimeProject.services;

import java.util.List;

import com.project.TimeSheet.TimeProject.models.TimeWork;

public interface TimeWorkService {
	
	public List<TimeWork> getAllTimeWork();
	
	public TimeWork getTimeWorkById(Long id);
	
	public TimeWork addTimeWork(TimeWork t);
	
	public TimeWork updateTimeWork(TimeWork t);
	
	public void deleteTimeWorkById(Long id);
	

}
