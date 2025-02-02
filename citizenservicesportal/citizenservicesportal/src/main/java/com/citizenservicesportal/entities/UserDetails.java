package com.citizenservicesportal.entities;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import com.citizenservicesportal.enums.Area;
import com.citizenservicesportal.enums.Caste;
import com.citizenservicesportal.enums.EmploymentStatus;
import com.citizenservicesportal.enums.Gender;
import com.citizenservicesportal.enums.MaritalStatus;
import com.citizenservicesportal.enums.YesNo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	 * this is a Entity Class for the system this is the definition of the table in
	 * Database [citizenservicesportal]
	 */
		@SuppressWarnings("deprecation")
		@Id
	    @GeneratedValue(generator = "custom-gen")
		
		/*
		 * this for the auto generation of userid whose loginc is written in the
		 * IdGenerator class
		 */
		
	    @GenericGenerator(name = "custom-gen", strategy = "com.citizenservicesportal.entities.IdGenerator")
	    @Column(name = "userid")
	    private Integer userID;

	    @Column(name = "firstname", nullable = false, length = 100)
	    @NotBlank(message = "First Name is required")
	    private String firstName;

	    @Column(name = "middlename", nullable = false, length = 100)
	    @NotBlank(message = "Middle Name is required")
	    private String middleName;

	    @Column(name = "lastname", nullable = false, length = 100)
	    @NotBlank(message = "Last Name is required")
	    private String lastName;

	    @Column(name = "dateofbirth", nullable = false)
	    @NotNull(message = "Date of Birth is a mandatory field")
	    @Temporal(TemporalType.DATE)
	    private Date dateofbirth;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "gender", nullable = false)
	    private Gender gender;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "marital_status", nullable = false)
	    private MaritalStatus maritalStatus;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "area", nullable = false)
	    private Area area;

	    @Column(name = "state", nullable = false, length = 100)
	    @NotBlank(message = "State is required")
	    private String state;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "caste", nullable = false)
	    private Caste caste;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "differently_abled", nullable = false)
	    private YesNo differentlyAbled = YesNo.NO;

	    @Column(name = "differently_abled_percentage")
	    @Min(value = 1, message = "Percentage must be between 1 and 100")
	    @Max(value = 100, message = "Percentage must be between 1 and 100")
	    private Integer differentlyAbledPercentage;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "minority", nullable = false)
	    private YesNo minority = YesNo.NO;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "student", nullable = false)
	    private YesNo student = YesNo.NO;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "current_employment", nullable = false)
	    private EmploymentStatus currentEmployment;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "bpl", nullable = false)
	    private YesNo bpl = YesNo.NO;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "hardship", nullable = false)
	    private YesNo hardship = YesNo.NO;

	    @Column(name = "family_income")
	    private Double familyIncome;

	    @Column(name = "pincode", nullable = false, length = 6)
	    @NotBlank(message = "Pincode is required")
	    @Pattern(regexp = "\\d{6}", message = "Pincode must be 6 digits")
	    private String pincode;

	    @Column(name = "mobilenumber", nullable = false, unique = true, length = 10)
	    @NotBlank(message = "Mobile number is required")
	    @Pattern(regexp = "\\d{10}", message = "Mobile Number must be 10 digits")
	    private String mobileNumber;

	    @Column(name = "aadharnumber", nullable = false, unique = true, length = 12)
	    @NotBlank(message = "Aadhar number is required")
	    @Pattern(regexp = "\\d{12}", message = "Aadhar Number must be 12 digits")
	    private String aadharNumber;

	    @Column(name = "email", unique = true, length = 100)
	    @Email(message = "Invalid email format")
	    private String email;

		/*
		 * here the lenght of the password is 300, since the plan is to store using
		 * hashing methods
		 */
	    @Column(name = "password", nullable = false, length = 300)
	    @NotBlank(message = "Please enter a password")
	    private String password;

//	    public void setArea(Area area) {
//	    	this.area = area;
//	    }
	    
}
