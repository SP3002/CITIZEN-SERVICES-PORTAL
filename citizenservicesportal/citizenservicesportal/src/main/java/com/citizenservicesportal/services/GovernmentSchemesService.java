package com.citizenservicesportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizenservicesportal.dto.UsersDTO;
import com.citizenservicesportal.entities.GovernmentSchemes;
import com.citizenservicesportal.repositories.GovernmentSchemesRepository;

@Service
public class GovernmentSchemesService {

	@Autowired
	private GovernmentSchemesRepository governmentschemesrepository;
	
	public List<GovernmentSchemes> getEligibleSchemes(UsersDTO user){
		return governmentschemesrepository.findEligibleSchemes(user);
	}
	
}
