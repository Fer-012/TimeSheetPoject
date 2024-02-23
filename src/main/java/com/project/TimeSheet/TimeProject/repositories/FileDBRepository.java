package com.project.TimeSheet.TimeProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TimeSheet.TimeProject.models.FileDB;
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
