package com.project.TimeSheet.TimeProject.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TimeSheet.TimeProject.models.TimeWork;
import com.project.TimeSheet.TimeProject.repositories.TimeWorkRepository;
import com.project.TimeSheet.TimeProject.services.TimeWorkService;

@Service
public class TimeWorkServiceImpl implements TimeWorkService  {

	@Autowired
	private TimeWorkRepository timeWorkRepository;
	@Override
	public List<TimeWork> getAllTimeWork() {
		// TODO Auto-generated method stub
		return timeWorkRepository.findAll();
	}

	@Override
	public TimeWork getTimeWorkById(Long id) {
		// TODO Auto-generated method stub
		Optional<TimeWork> timework = timeWorkRepository.findById(id);
		return timework.isPresent()? timework.get() : null;
	}

	@Override
	public TimeWork addTimeWork(TimeWork t) {
		// TODO Auto-generated method stub
		return timeWorkRepository.save(t);
	}

	@Override
	public TimeWork updateTimeWork(TimeWork t) {
		// TODO Auto-generated method stub
		return timeWorkRepository.save(t);
	}

	@Override
	public void deleteTimeWorkById(Long id) {
		// TODO Auto-generated method stub
		timeWorkRepository.deleteById(id);
		
	}

}
