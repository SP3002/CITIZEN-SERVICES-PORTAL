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
	
	private Integer UserID;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private Date DateOfBirth;
	private String Gender;
	private String Pincode;
	private String Email;
	private String MobileNumber;
	private String AadharNumber;
	private String Password;
	
}
