package com.citizenservicesportal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citizenservicesportal.dto.LoginDTO;
import com.citizenservicesportal.entities.UserDetails;
import com.citizenservicesportal.repositories.UsersRepository;

@Service
public class LoginService {

	@Autowired
	private UsersRepository usersRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public boolean authenticateUser(LoginDTO loginDTO) {
		
		Optional<UserDetails> user = Optional.empty();
		
		if( usersRepo.existsByEmail(loginDTO.getUsername()) ) {
			user = usersRepo.findByEmail(loginDTO.getUsername());
		}
		else if( usersRepo.existsByMobileNumber( loginDTO.getUsername() ) ) {
			user = usersRepo.findByMobileNumber( loginDTO.getUsername() );
		}
		else if( usersRepo.existsByAadharNumber( loginDTO.getUsername()) ) {
			user = usersRepo.findByAadharNumber( loginDTO.getUsername() );
		}
		
		System.out.println("username : " + user.get()); 
		System.out.println("password : " + loginDTO.getPassword());
		
		if( user.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), user.get().getPassword()) ) {
			System.out.println("username : " + user.get()); 
			System.out.println("password : " + loginDTO.getPassword());
			return true;
		}
		
		return false;
		
	}
	
}
