package com.citizenservicesportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservicesportal.dto.UsersDTO;
import com.citizenservicesportal.services.UserService;

@RestController
@RequestMapping("/CitizenServicesPortal")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/RegisterUser")
	public void UserRegistration(@RequestBody UsersDTO user) {
		
		System.out.println(user);
		userService.RegisterUser(user);
		
	}
	
	@GetMapping("/FindUserByEmail")
	public void FindByEmail( @RequestParam String email ) {
		
		userService.GetUserByEmail(email);
		
	}
	
}
