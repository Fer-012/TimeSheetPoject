package com.project.TimeSheet.TimeProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import com.project.TimeSheet.TimeProject.models.Projects;
import com.project.TimeSheet.TimeProject.models.TimeWork;
@Repository
public interface TimeWorkRepository extends JpaRepository<TimeWork,Long>{

    //  List<TimeWork> findByIdProject(Projects project);

    long count();


    @Query(value = "SELECT timesheet.dateDuJour as x, sum(timesheet.workHours) as y from timesheet group by timesheet.dateDuJour"
	, nativeQuery = true
	)
    List<Map<String, Integer>> countByDay();


}
