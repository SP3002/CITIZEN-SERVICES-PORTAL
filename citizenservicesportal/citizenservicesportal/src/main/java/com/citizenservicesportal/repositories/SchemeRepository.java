package com.citizenservicesportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.citizenservicesportal.entities.GovernmentSchemes;

@Repository
public interface SchemeRepository
		extends JpaRepository<GovernmentSchemes, Integer>, JpaSpecificationExecutor<GovernmentSchemes> {

}
