package com.project.TimeSheet.TimeProject.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.TimeSheet.TimeProject.models.Admin;
import com.project.TimeSheet.TimeProject.models.AdminDetailsImpl;
import com.project.TimeSheet.TimeProject.repositories.AdminRepository;
import com.project.TimeSheet.TimeProject.services.AdminDetailsService;

@Service
public class AdminDetailsServiceImpl implements AdminDetailsService{

	@Autowired
	AdminRepository adminRepository;

	@Override
	public UserDetails laodUserByEmail(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Admin Not Found with email: " + email));
		return AdminDetailsImpl.build(admin);
	}

	@Override
	public Optional<Admin> findAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepository.findByEmail(email);
	}

	@Override
	public Optional<Admin> findAdminByResetToken(String resetToken) {
		// TODO Auto-generated method stub
		return adminRepository.findByResetToken(resetToken);
	}

	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		adminRepository.save(admin);
	}

}
