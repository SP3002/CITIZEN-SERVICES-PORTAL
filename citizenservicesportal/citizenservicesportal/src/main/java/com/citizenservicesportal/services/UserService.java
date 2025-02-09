package com.citizenservicesportal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citizenservicesportal.dto.LoginDTO;
import com.citizenservicesportal.dto.UsersDTO;
import com.citizenservicesportal.entities.UserDetails;
import com.citizenservicesportal.enums.Area;
import com.citizenservicesportal.enums.Caste;
import com.citizenservicesportal.enums.EmploymentStatus;
import com.citizenservicesportal.enums.Gender;
import com.citizenservicesportal.enums.MaritalStatus;
import com.citizenservicesportal.enums.YesNo;
import com.citizenservicesportal.repositories.UsersRepository;

@Service
public class UserService{

	 @Autowired
	 private UsersRepository userRepository;
	 
	 @Autowired
	 private PasswordEncoder passwordEncoder;


	    public String registerUser(UsersDTO userDTO) {
	        // Check if user already exists
	        if (userRepository.existsByEmail(userDTO.getEmail()) ||
	            userRepository.existsByMobileNumber(userDTO.getMobileNumber()) ||
	            userRepository.existsByAadharNumber(userDTO.getAadharNumber())) {
	            return "User already registered with provided email, mobile, or Aadhar.";
	        }

	        UserDetails user = new UserDetails();
	        user.setFirstName(userDTO.getFirstName());
	        user.setMiddleName(userDTO.getMiddleName());
	        user.setLastName(userDTO.getLastName());
	        user.setDateofbirth(userDTO.getDateOfBirth());
	        user.setGender(Gender.valueOf(userDTO.getGender().toUpperCase())); 
	        user.setMaritalStatus(MaritalStatus.valueOf(userDTO.getMaritalStatus().toUpperCase()));
	        user.setArea(Area.valueOf(userDTO.getArea().toUpperCase()));
	        user.setState(userDTO.getState());
	        user.setCaste(Caste.valueOf(userDTO.getCaste().toUpperCase()));
	        user.setDifferentlyAbled(YesNo.valueOf(userDTO.getDifferentlyAbled().toUpperCase()));
	        user.setDifferentlyAbledPercentage(userDTO.getDifferentlyAbledPercentage());
	        user.setMinority(YesNo.valueOf(userDTO.getMinority().toUpperCase()));
	        user.setStudent(YesNo.valueOf(userDTO.getStudent().toUpperCase()));
	        user.setCurrentEmployment(EmploymentStatus.valueOf(userDTO.getCurrentEmployment().toUpperCase()));
	        user.setBpl(YesNo.valueOf(userDTO.getBpl().toUpperCase()));
	        user.setHardship(YesNo.valueOf(userDTO.getHardship().toUpperCase()));
	        user.setFamilyIncome(userDTO.getFamilyIncome());
	        user.setPincode(userDTO.getPincode());
	        user.setMobileNumber(userDTO.getMobileNumber());
	        user.setAadharNumber(userDTO.getAadharNumber());
	        user.setEmail(userDTO.getEmail());
	        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
	        System.out.println("hashed password : " + hashedPassword );
	        user.setPassword( hashedPassword ); 

	        userRepository.save(user);
	        return "User registered successfully!";
	    }

	    public Optional<UserDetails> getUserByUsername( LoginDTO loginDTO ) {
	    	
	    	 if ( userRepository.existsByEmail( loginDTO.getUsername() ) )
			 {
	    		 return userRepository.findByEmail( loginDTO.getUsername() );
	    	 }
	    	 else if ( userRepository.existsByMobileNumber( loginDTO.getUsername() ) )
	    	 {
	    		 return userRepository.findByMobileNumber( loginDTO.getUsername() );
	    	 }
	    	 else if( userRepository.existsByAadharNumber( loginDTO.getUsername() ) )
	    	 {
	    		 return userRepository.findByAadharNumber( loginDTO.getUsername() );
	    	 }
	    	 
	    	return null;
	    			 
   	 }
	    
	    public boolean updateProfile(UsersDTO updatedUser, String aadharnumber) {
	    	
	    	Optional<UserDetails> user = userRepository.findByAadharNumber(aadharnumber);
	    	
	    	if( user != null ) {
	    		UserDetails existingUser = (UserDetails) user.get();
	    		    	
	    		existingUser.setFirstName(updatedUser.getFirstName());
	    		existingUser.setMiddleName(updatedUser.getMiddleName());
	    		existingUser.setLastName(updatedUser.getLastName());
	    		existingUser.setDateofbirth(updatedUser.getDateOfBirth());
	    		existingUser.setGender(Gender.valueOf(updatedUser.getGender().toUpperCase()));
	    		existingUser.setMaritalStatus(MaritalStatus.valueOf(updatedUser.getMaritalStatus().toUpperCase()) );
	    		existingUser.setArea(Area.valueOf(updatedUser.getArea().toUpperCase()));
	    		existingUser.setState(updatedUser.getState());
	    		existingUser.setCaste(Caste.valueOf(updatedUser.getCaste().toUpperCase()));
	    		existingUser.setDifferentlyAbled(YesNo.valueOf(updatedUser.getCaste().toUpperCase()));
	    		existingUser.setDifferentlyAbledPercentage(updatedUser.getDifferentlyAbledPercentage());
	    		existingUser.setMinority(YesNo.valueOf(updatedUser.getMinority().toUpperCase()));
	    		existingUser.setStudent(YesNo.valueOf(updatedUser.getStudent().toUpperCase()));
	    		existingUser.setCurrentEmployment(EmploymentStatus.valueOf(updatedUser.getCurrentEmployment().toUpperCase()));
	    		existingUser.setBpl(YesNo.valueOf(updatedUser.getBpl().toUpperCase()) );
	    		existingUser.setHardship(YesNo.valueOf(updatedUser.getHardship().toUpperCase()));
	    		existingUser.setFamilyIncome(updatedUser.getFamilyIncome());
	    		existingUser.setPincode(updatedUser.getPincode());
	    		existingUser.setMobileNumber(updatedUser.getMobileNumber());
//	    		existingUser.setAadharNumber(updatedUser.getAadharNumber());
	    		existingUser.setEmail(updatedUser.getEmail());
	    		existingUser.setPassword(updatedUser.getPassword());
	    	
	    		userRepository.save(existingUser);
	    		
	    		return true;
	    	}

	        
	        return false;
	    	
	    }
	    	
}