package com.project.TimeSheet.TimeProject.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TimeSheet.TimeProject.models.User;
import com.project.TimeSheet.TimeProject.repositories.UserRepository;
import com.project.TimeSheet.TimeProject.services.UsersCRUDService;

@Service
public class UsersCRUDServiceImpl implements UsersCRUDService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		return user.isPresent()? user.get() :null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

}
