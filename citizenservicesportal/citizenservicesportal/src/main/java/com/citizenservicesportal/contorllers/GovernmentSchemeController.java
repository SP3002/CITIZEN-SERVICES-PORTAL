package com.citizenservicesportal.contorllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservicesportal.dto.UsersDTO;
import com.citizenservicesportal.entities.GovernmentSchemes;
import com.citizenservicesportal.services.GovernmentSchemesService;

@RestController
@RequestMapping("/CitizenServicesPortal")
public class GovernmentSchemeController {
	
	@Autowired
	private GovernmentSchemesService governmentschemesservice;
	
	@PostMapping("/eligibleschemes")
	public ResponseEntity<List<GovernmentSchemes>> getEligibleSchemes(@RequestBody UsersDTO user){
		
		List<GovernmentSchemes> schemes = governmentschemesservice.getEligibleSchemes(user);
		
		if(schemes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(schemes);
		}
		return ResponseEntity.ok(schemes);
		
	}

}
