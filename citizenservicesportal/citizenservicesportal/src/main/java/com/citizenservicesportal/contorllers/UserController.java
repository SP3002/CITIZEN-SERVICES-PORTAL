package com.citizenservicesportal.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservicesportal.dto.UsersDTO;
import com.citizenservicesportal.entities.UserDetails;
import com.citizenservicesportal.services.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/CitizenServicesPortal")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/RegisterUser")
	public void UserRegistration(@RequestBody UsersDTO user) {
		
		System.out.println(user);
		userService.registerUser(user);
		
	}
	
	@GetMapping("/UserPage")
	public ResponseEntity<?> getUserPage(HttpSession session){
		
		UserDetails user = (UserDetails) session.getAttribute("UserDetails");
		
		if(user != null) {
			return ResponseEntity.ok(user);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unable to get user");
		}
		
	}
	
	
	@GetMapping("/getProfile")
	 public ResponseEntity<UserDetails> getUserProfile(HttpSession session) {
	        UserDetails user = (UserDetails) session.getAttribute("UserDetails");

	        if (user == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	        return ResponseEntity.ok(user);
	    }
	
	@PostMapping("/updateProfile")
	public ResponseEntity<String> updateProfile(@RequestBody UsersDTO updatedUser, HttpSession session) {
        
		UserDetails sessionUser = (UserDetails) session.getAttribute("UserDetails");

        if (sessionUser == null) {
            return ResponseEntity.status(401).body("User not logged in");
        }

        boolean isUpdated = userService.updateProfile(updatedUser, sessionUser.getAadharNumber());
        
        if (isUpdated) {
            session.setAttribute("UserDetails", updatedUser); // Update session with new user data
            return ResponseEntity.ok("Profile updated successfully");
        }
        return ResponseEntity.status(500).body("Failed to update profile");
    }
	
}