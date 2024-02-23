package com.project.TimeSheet.TimeProject.controllers;

import java.util.List;

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

import com.project.TimeSheet.TimeProject.models.WorkHourDay;
import com.project.TimeSheet.TimeProject.services.WorkTimeDayService;

@RequestMapping("api/WorkHourDayController/")
@CrossOrigin(origins="*", maxAge=4800)
@RestController
public class WorkHourDayController {

	@Autowired
	public WorkTimeDayService workTimeDayService;
	
	@GetMapping("get_timeday")
	public List<WorkHourDay> getAllWorkHourDay() {
		return workTimeDayService.getAllWorkHourDay();
	}
	
	@DeleteMapping(" workTimeDayById/{id}")
	public void deleteWorkHourDayById(@PathVariable Long id) {
		workTimeDayService.deleteWorkHourDayById(id);
	}
	

	@PostMapping("add_timeday")
	public WorkHourDay addWorkHourDay(@RequestBody WorkHourDay w) {
		System.out.println("test project request "+ w);
		return workTimeDayService.addWorkHourDay(w);
	}
	

	@PutMapping
	public WorkHourDay editWorkHourDay(@RequestBody WorkHourDay w) {
		return workTimeDayService.updateWorkHourDay(w);
	}

}
