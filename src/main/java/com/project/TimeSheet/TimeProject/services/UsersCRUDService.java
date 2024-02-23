package com.project.TimeSheet.TimeProject.services;

import java.util.List;

import com.project.TimeSheet.TimeProject.models.User;

public interface UsersCRUDService {

	
  public List<User> getAllUsers();
	
	public User getUserById(Long id);
	
	public User updateUser(User user);
	
	public void deleteUserById(Long id);
}
