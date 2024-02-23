package com.project.TimeSheet.TimeProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.TimeSheet.TimeProject.models.User;
import com.project.TimeSheet.TimeProject.services.UsersCRUDService;


@RequestMapping("api/UsersCRUDController/")
@CrossOrigin(origins="*", maxAge=4800)
@RestController
public class UsersCRUDController {
	
	@Autowired
	public UsersCRUDService usersCRUDService;
	
	
	@GetMapping("getUser")
	public List<User> getAllUsers() {
		return usersCRUDService.getAllUsers();
	}
	@GetMapping("{id}")
	public User getUsersById(@PathVariable Long id) {
		System.out.println("test project request "+id);
		return usersCRUDService.getUserById(id);
	}
	
	@DeleteMapping("{id}")
	public void deleteUserById(@PathVariable Long id) {
		usersCRUDService.deleteUserById(id);
	}

	@PutMapping("{id}")
	public User editUser(@RequestBody  User user) {
		return usersCRUDService.updateUser(user);
	}
	

}
