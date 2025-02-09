package com.citizenservicesportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizenservicesportal.entities.GovernmentSchemes;
import com.citizenservicesportal.entities.UserDetails;
import com.citizenservicesportal.repositories.SchemeRepository;
import com.citizenservicesportal.repositories.SchemeSpecification;

@Service
public class SchemesService {

	@Autowired
    private SchemeRepository schemeRepository;

    public List<GovernmentSchemes> getEligibleSchemes(UserDetails user, Integer schemeTypeId) {
        return schemeRepository.findAll(SchemeSpecification.getEligibleSchemes(user, schemeTypeId));
    }
	
}
