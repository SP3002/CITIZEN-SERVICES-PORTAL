package com.citizenservicesportal.contorllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CitizenServicesPortal")
public class SessionController {

	@GetMapping("/session-expired")
	public ResponseEntity<Map<String, String>> sessionExpired(){
		
		Map<String, String> response = new HashMap<>();
		response.put("message", "Session timed-out. Redirecting to login page");
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		
	}
	
}
