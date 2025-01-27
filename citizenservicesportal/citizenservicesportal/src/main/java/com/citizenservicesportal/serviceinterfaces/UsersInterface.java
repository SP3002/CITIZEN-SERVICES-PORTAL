package com.citizenservicesportal.serviceinterfaces;

import com.citizenservicesportal.dto.UsersDTO;
import com.citizenservicesportal.entities.UserDetails;

public interface UsersInterface {

	/*
	 *  contract for the service layer 
	 */
	
	/*
	 * method to register [RegisterUser] the user in the system
	 */
	public void RegisterUser(UsersDTO user);
	
	
	/*
	 * methods to get user details via 
	 * [GetUserByEmail], [GetUserByMobile],[GetUserByAdhaarNumber] 
	 * these are the methods by which the user can login
	 * (user can these fields as its own unique values)
	 */
	public UserDetails GetUserByEmail(String email);
	public UserDetails GetUserByMobile(String mobileno);
	public UserDetails GetUserByAdhaarNumber(String adhaarno);
	
}
