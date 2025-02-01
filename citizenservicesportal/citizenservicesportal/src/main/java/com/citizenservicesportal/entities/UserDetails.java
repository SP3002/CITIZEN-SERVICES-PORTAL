package com.citizenservicesportal.entities;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@Entity
@Table(name="users")
public class UserDetails {
	
	/*
	 * Class defining the structure of data storing in the DB by implementing the
	 * validations to the data
	 */
	
	@SuppressWarnings("deprecation")
	@Id
	@GeneratedValue(generator = "custom-gen")
	
	/*
	 * helps to map the generator used for autogenerating the ID's
	 * [@GenericGenerator]
	 */
	@GenericGenerator(name = "custom-gen", strategy = "com.citizenservicesportal.entities.IdGenerator")
	@Column(name="userid")
	private Integer userID;
	
	@Column(name="firstname", nullable = false)
	@NotBlank(message = "First Name is required")
	private String firstName;
	
	@Column(name="middlename", nullable = false)
	@NotBlank(message = "Middle Name is required")
	private String middleName;
	
	@Column(name="lastname", nullable = false)
	@NotBlank(message = "Last Name is required")
	private String lastName;
	
	@Column(name="dateofbirth", nullable = false)
	@NotNull(message = "Date of Birth is a mandatory field")
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	
	@Column(name = "gender", nullable = false)
	@Pattern(regexp = "M|F", message = "MALE / FEMALE")
	private String gender;
	
	@Column(name="pincode", nullable = false, length = 6)
	@NotBlank(message = "Pincode is required")
	@Pattern(regexp = "\\d{6}", message = "pincode must of 6-Digits")
	private String pincode;
	
	@Column(name="mobilenumber", nullable = false, length = 10, unique = true)
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "\\d{10}", message = "Mobile Number should be only 10-Digits")
	private String mobileNumber;
	
	@Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    private String email;
	
	@Column(name="aadharnumber", nullable = false, length = 12, unique = true)
	@NotBlank(message = "Aadhar number is required")
	@Pattern(regexp = "\\d{12}", message = "Aadhar Number must contain 12-digits")	
	private String aadharNumber;
	
	@Column(name="password", nullable = false, length = 5)
	@NotBlank(message = "Please enter a password")
	@Size(min = 5, message = "Password should contain 5-Digits")
	private String password;

}
