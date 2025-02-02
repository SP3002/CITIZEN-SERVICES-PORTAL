package com.citizenservicesportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizenservicesportal.entities.UserDetails;

public interface UsersRepository extends JpaRepository<UserDetails, Integer> {
	
	Optional<UserDetails> findByEmail(String email);
    
    Optional<UserDetails> findByMobileNumber(String mobileNumber);
    
    Optional<UserDetails> findByAadharNumber(String aadharNumber);

    boolean existsByEmail(String email);
	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByAadharNumber(String aadharNumber);
	 

}
