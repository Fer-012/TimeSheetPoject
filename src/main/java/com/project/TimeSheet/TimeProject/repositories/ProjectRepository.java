package com.project.TimeSheet.TimeProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.TimeSheet.TimeProject.models.Projects;   
@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {


    @Query("SELECT p FROM Projects p WHERE p.isShown = true")
    List<Projects> findSentToAdminProjects();

    long count();

        @Query(value = "SELECT count(id) FROM Projects where adminDecision = :adminDecision")
	public Long count(@Param("adminDecision") boolean adminDecision);


}
