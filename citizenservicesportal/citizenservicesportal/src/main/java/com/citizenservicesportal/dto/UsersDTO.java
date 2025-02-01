package com.citizenservicesportal.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersDTO {

	/*
	 * this is a DATA TRANSFER OBEJCT [DTO] class which helps to hide the direct
	 * access to the DATA
	 */
	
	private Integer userID;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateofbirth;
	private String gender;
	private String pincode;
	private String email;
	private String mobileNumber;
	private String aadharNumber;
	private String password;
	
}
