package com.project.TimeSheet.TimeProject.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TimeSheet.TimeProject.models.WorkHourDay;
import com.project.TimeSheet.TimeProject.repositories.WorkTimeDayRepository;
import com.project.TimeSheet.TimeProject.services.WorkTimeDayService;

@Service
public class WorkHourDayServiceImpl implements WorkTimeDayService{

	@Autowired
	private WorkTimeDayRepository workTimeDayRepository;
	@Override
	public List<WorkHourDay> getAllWorkHourDay() {
		// TODO Auto-generated method stub
		return workTimeDayRepository.findAll();
	}

	@Override
	public WorkHourDay getWorkHourDayById(Long id) {
		// TODO Auto-generated method stub
		Optional<WorkHourDay> workhourday = workTimeDayRepository.findById(id);
		
		return workhourday.isPresent()? workhourday.get() : null;
	}

	@Override
	public WorkHourDay addWorkHourDay(WorkHourDay w) {
		// TODO Auto-generated method stub
		return workTimeDayRepository.save(w);
	}

	@Override
	public WorkHourDay updateWorkHourDay(WorkHourDay w) {
		// TODO Auto-generated method stub
		return workTimeDayRepository.save(w);
	}

	@Override
	public void deleteWorkHourDayById(Long id) {
		// TODO Auto-generated method stub
		
		workTimeDayRepository.deleteById(id);
	}

}
