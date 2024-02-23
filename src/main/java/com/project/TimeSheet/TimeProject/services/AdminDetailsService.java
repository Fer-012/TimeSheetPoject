package com.project.TimeSheet.TimeProject.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.TimeSheet.TimeProject.models.Admin;

public interface AdminDetailsService {
	UserDetails laodUserByEmail(String email)throws UsernameNotFoundException;

	 public Optional<Admin> findAdminByEmail(String email);
	    public Optional<Admin> findAdminByResetToken(String resetToken);
	    public void save(Admin admin);
}
