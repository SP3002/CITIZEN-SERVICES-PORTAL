package com.citizenservicesportal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

	@NotBlank(message = "Username (email, mobile, or Aadhar) is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;
	
}
