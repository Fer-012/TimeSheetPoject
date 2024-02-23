package com.project.TimeSheet.TimeProject.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.TimeSheet.TimeProject.jwt.JwtUtils;
import com.project.TimeSheet.TimeProject.models.ERole;
import com.project.TimeSheet.TimeProject.models.JwtResponse;
import com.project.TimeSheet.TimeProject.models.LoginRequest;
import com.project.TimeSheet.TimeProject.models.MessageResponse;
import com.project.TimeSheet.TimeProject.models.Role;
import com.project.TimeSheet.TimeProject.models.SignupRequest;
import com.project.TimeSheet.TimeProject.models.User;
import com.project.TimeSheet.TimeProject.models.UserDetailsImpl;
import com.project.TimeSheet.TimeProject.repositories.RoleRepository;
import com.project.TimeSheet.TimeProject.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*",maxAge = 4800)
@RequestMapping("api/auth/")

public class UserController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("login")
	public ResponseEntity<?> authenticaUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getFirstName(), userDetails.getEmail(), roles));
	}

	@PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		System.out.println("test body "+signUpRequest.getRoles() );
		
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}


		// Create new user's account

		User user = new User(signUpRequest.getFirstName(),signUpRequest.getLastName(), signUpRequest.getEmail(),signUpRequest.getMobile(), encoder.encode(signUpRequest.getPassword()));
		String roleRequest="" ;
		System.out.println("signUpRequest : "+ signUpRequest);
		if (signUpRequest.getRoles()!=null && signUpRequest.getRoles().length()!=0){
			 roleRequest  = signUpRequest.getRoles();

		}

		Set<String> strRoles= new HashSet<>();
		
		strRoles.add(roleRequest);
		
		Set<Role> roles = new HashSet<>();
		
		//System.out.println("The value of myVar is: " + user);
		if (strRoles == null) {
			System.out.println("The value of myVar is: " + roles.size());
			System.out.println("im here if 1");
			/*Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role NOT_ROLE is not found."));
			System.out.println("role is : " + userRole);
			roles.add(userRole);*/
			

		} else {

			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role ROLE_ADMIN is not found."));
					roles.add(adminRole);
					break;

				case "client":
					Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
							.orElseThrow(() -> new RuntimeException("Error: Role ROLE_CLIENT is not found."));
					roles.add(clientRole);
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role ROLE_USER is not found."));
					roles.add(userRole);
				}
			});

		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}

	@CrossOrigin(origins = "*", maxAge = 4800)
	@GetMapping(value = "test", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String test() {

		return "test ";
	}

}
