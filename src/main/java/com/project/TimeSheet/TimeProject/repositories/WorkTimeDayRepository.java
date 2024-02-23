package com.project.TimeSheet.TimeProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.TimeSheet.TimeProject.models.WorkHourDay;

public interface WorkTimeDayRepository extends JpaRepository<WorkHourDay, Long> {

    long count();

}
