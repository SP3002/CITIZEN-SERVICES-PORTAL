package com.citizenservicesportal.contorllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservicesportal.dto.LoginDTO;
import com.citizenservicesportal.entities.UserDetails;
import com.citizenservicesportal.services.LoginService;
import com.citizenservicesportal.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/CitizenServicesPortal")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginControllers {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public ResponseEntity<?> getLoginPage(HttpSession session) {
		
		UserDetails user = (UserDetails) session.getAttribute("UserDetails");
		
		if( user != null) {
			return ResponseEntity.ok(user);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Not logged in");
		}
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO, BindingResult result, HttpSession session){
		
		if( result.hasErrors() ) {
			return ResponseEntity.badRequest().body("Invalid Input Data!");
		}
		
		boolean isAuthenticated = loginService.authenticateUser(loginDTO);
		
		if( isAuthenticated ) {
			
			Optional<UserDetails> userdetails = userService.getUserByUsername(loginDTO);
			
			if( userdetails.isPresent() ) {
				
				UserDetails userDetails = userdetails.get();
				
				session.setAttribute("UserDetails", userDetails);
				
				return ResponseEntity.ok().body("Login Successful...");
				
			}
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
			
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password!!!...");
		}
		
	}

}
