package com.project.TimeSheet.TimeProject.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
	
	UserDetails laodUserByEmail(String email)throws UsernameNotFoundException;

}
