package com.citizenservicesportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizenservicesportal.entities.UserDetails;

public interface UsersRepository extends JpaRepository<UserDetails, Integer> {

}
