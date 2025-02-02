package com.citizenservicesportal.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class UsersDTO {

	/*
	 * this is a DATA TRANSFER OBEJCT [DTO] class which helps to hide the direct
	 * access to the DATA
	 */
	
	@NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Middle Name is required")
    private String middleName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @NotNull(message = "Date of Birth is required")
    private Date dateOfBirth;

    @NotNull(message = "Gender is required")
    private String gender;

    @NotNull(message = "Marital Status is required")
    private String maritalStatus;

    @NotNull(message = "Area is required")
    private String area;

    @NotBlank(message = "State is required")
    private String state;

    @NotNull(message = "Caste is required")
    private String caste;

    private String differentlyAbled = "NO";

    @Min(value = 1, message = "Percentage must be between 1 and 100")
    @Max(value = 100, message = "Percentage must be between 1 and 100")
    private Integer differentlyAbledPercentage;

    private String minority = "NO";
    private String student = "NO";

    @NotNull(message = "Current Employment is required")
    private String currentEmployment;

    private String bpl = "NO";
    private String hardship = "NO";

    private Double familyIncome;

    @NotBlank(message = "Pincode is required")
    @Pattern(regexp = "\\d{6}", message = "Pincode must be 6 digits")
    private String pincode;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Aadhar number is required")
    @Pattern(regexp = "\\d{12}", message = "Aadhar Number must be 12 digits")
    private String aadharNumber;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Please enter a password")
    @Size(min = 5, message = "Password should be at least 5 characters")
    private String password;
	
}
