package com.project.TimeSheet.TimeProject.services;

import java.util.List;

import com.project.TimeSheet.TimeProject.models.WorkHourDay;



public interface WorkTimeDayService {

public List<WorkHourDay> getAllWorkHourDay();
	
	public WorkHourDay getWorkHourDayById(Long id);
	
	public WorkHourDay addWorkHourDay(WorkHourDay w);
	
	public WorkHourDay updateWorkHourDay(WorkHourDay w);
	
	public void deleteWorkHourDayById(Long id);
}
