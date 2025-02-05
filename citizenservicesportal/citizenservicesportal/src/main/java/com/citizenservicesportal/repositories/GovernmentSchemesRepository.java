package com.citizenservicesportal.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.citizenservicesportal.dto.UsersDTO;
import com.citizenservicesportal.entities.GovernmentSchemes;
import com.citizenservicesportal.enums.Caste;
import com.citizenservicesportal.enums.EmploymentStatus;
import com.citizenservicesportal.enums.Gender;
import com.citizenservicesportal.enums.YesNo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class GovernmentSchemesRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<GovernmentSchemes> findEligibleSchemes (UsersDTO user){
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GovernmentSchemes> query = cb.createQuery(GovernmentSchemes.class);
        Root<GovernmentSchemes> scheme = query.from(GovernmentSchemes.class);

        List<Predicate> predicates = new ArrayList<>();

     // Gender filter (Handles Male, Female, Other, and All)
        predicates.add(cb.or(
            cb.equal(scheme.get("gender"), "ALL"), 
            cb.equal(scheme.get("gender"), Gender.valueOf(user.getGender().toUpperCase()))
        ));

        // Caste filter (Handles GEN, OBC, SC, ST, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("caste"), "ALL"), 
            cb.equal(scheme.get("caste"), Caste.valueOf(user.getCaste().toUpperCase()))
        ));

        // Minority filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("minority"), "ALL"), 
            cb.equal(scheme.get("minority"), YesNo.valueOf(user.getMinority().toUpperCase()))
        ));

        // Student filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("student"), "ALL"), 
            cb.equal(scheme.get("student"), YesNo.valueOf(user.getStudent().toUpperCase()))
        ));

        // Employment Status filter (Unemployed, Employed, Self-Employed, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("employmentStatus"), "ALL"), 
            cb.equal(scheme.get("employmentStatus"), EmploymentStatus.valueOf(user.getCurrentEmployment().toUpperCase()))
        ));

        // BPL filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("bpl"), "ALL"), 
            cb.equal(scheme.get("bpl"), YesNo.valueOf(user.getBpl().toUpperCase()) )
        ));

        // Hardship filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("hardship"), "ALL"), 
            cb.equal(scheme.get("hardship"), YesNo.valueOf(user.getHardship().toUpperCase()) )
        ));

        // Differently Abled filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("differentlyAbled"), "ALL"), 
            cb.equal(scheme.get("differentlyAbled"), YesNo.valueOf(user.getDifferentlyAbled().toUpperCase()) )
        ));

        // Income Range filter (Handles Min and Max Income)
        predicates.add(cb.or(cb.isNull(scheme.get("minIncome")), 
                             cb.lessThanOrEqualTo(scheme.get("minIncome"), user.getFamilyIncome())));
        predicates.add(cb.or(cb.isNull(scheme.get("maxIncome")), 
                             cb.greaterThanOrEqualTo(scheme.get("maxIncome"), user.getFamilyIncome())));

        // State filter (Handles all states)
        predicates.add(cb.or(
            cb.equal(scheme.get("state"), "ALL"), 
            cb.equal(scheme.get("state"), user.getState())
        ));

        query.select(scheme).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
 
		
	}
	
}
