package com.citizenservicesportal.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizenservicesportal.dto.UsersDTO;
import com.citizenservicesportal.entities.UserDetails;
import com.citizenservicesportal.repository.UsersRepository;
import com.citizenservicesportal.serviceinterfaces.UsersInterface;

@Service
public class UserService implements UsersInterface {

	@Autowired
	UsersRepository repository;
	
	@Override
	public void RegisterUser(UsersDTO user) {

		UserDetails userDetails = new UserDetails();
		BeanUtils.copyProperties(user, userDetails);
		
		System.out.println("User Has been Registered....");
		
	}

	@Override
	public UserDetails GetUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails GetUserByMobile(String mobileno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails GetUserByAdhaarNumber(String adhaarno) {
		// TODO Auto-generated method stub
		return null;
	}

}
