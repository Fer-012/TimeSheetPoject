package com.project.TimeSheet.TimeProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TimeSheet.TimeProject.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	Boolean existsByEmail(String email);
	Optional<Admin> findByEmail(String email);
	 Optional<Admin> findByResetToken(String resetToken);
}
