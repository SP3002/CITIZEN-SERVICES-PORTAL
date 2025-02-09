package com.citizenservicesportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citizenservicesportal.entities.SchemeType;

@Repository
public interface SchemeTypeRepo extends JpaRepository<SchemeType, Integer>{

	@Query("SELECT s FROM SchemeType s WHERE s.schemeType = :schemeType")
	SchemeType findBySchemeType(@Param("schemeType") String schemeType);	
}
