package com.citizenservicesportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.citizenservicesportal.entities.UserDetails;

public interface UsersRepository extends JpaRepository<UserDetails, Integer> {
	
	Optional<UserDetails> findByEmail(String email);
	Optional<UserDetails> findByAadharNumber(String aadharNumber);
	Optional<UserDetails> findByMobileNumber(String mobileNumber);
	
	Optional<UserDetails> findByEmailorAadharorMobile(
			
			@Param("email") String email,
			@Param("aadharNumber") String aadharNumber,
			@Param("mobileNumber") String mobileNumber
			
			);

}
