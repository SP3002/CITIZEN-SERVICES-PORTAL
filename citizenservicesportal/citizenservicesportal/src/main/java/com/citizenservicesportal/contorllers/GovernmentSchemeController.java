package com.citizenservicesportal.contorllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservicesportal.entities.GovernmentSchemes;
import com.citizenservicesportal.entities.UserDetails;
import com.citizenservicesportal.services.SchemeTypeService;
import com.citizenservicesportal.services.SchemesService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/CitizenServicesPortal")
@CrossOrigin(origins = "http://localhost:3000")
public class GovernmentSchemeController {
	
	@Autowired
	private SchemesService schemeservice;
	
	@Autowired
	private SchemeTypeService schemetypeservice;
	
	@PostMapping("/eligibleschemes")
	public ResponseEntity<List<GovernmentSchemes>> getEligibleSchemes(@RequestBody Map<String, String> request, HttpSession session){
		
//		System.out.println("/eligibleschemes");
		
		String schemeType = request.get("category");
		System.out.println(schemeType);
		
		Integer schemetypeid = schemetypeservice.getSchemeTypeId(schemeType);
		
		UserDetails user = (UserDetails) session.getAttribute("UserDetails");
		
		List<GovernmentSchemes> schemes = schemeservice.getEligibleSchemes(user, schemetypeid);
		
		for(GovernmentSchemes gov : schemes) {
			System.out.println("list of schemes"+ gov);
		}
		
		if(schemes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(schemes);
		}
		return ResponseEntity.ok(schemes);
		
	}

}
