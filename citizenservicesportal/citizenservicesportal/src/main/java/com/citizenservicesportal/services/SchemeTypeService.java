package com.citizenservicesportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizenservicesportal.entities.SchemeType;
import com.citizenservicesportal.repositories.SchemeTypeRepo;

@Service
public class SchemeTypeService {

	@Autowired
	SchemeTypeRepo schemetyperepo;
	
	public Integer getSchemeTypeId(String name) {
		
		SchemeType schemetype = schemetyperepo.findBySchemeType(name);
		
		System.out.println(schemetype.getSchemeType()+"   " + schemetype.getSchemetypeid());
		
		return schemetype.getSchemetypeid();
		
	}
	
}
