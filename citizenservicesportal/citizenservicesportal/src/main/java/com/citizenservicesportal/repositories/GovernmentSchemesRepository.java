package com.citizenservicesportal.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.citizenservicesportal.entities.GovernmentSchemes;
import com.citizenservicesportal.entities.UserDetails;

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
	
	public List<GovernmentSchemes> findEligibleSchemes (UserDetails user, Integer schemetypeID){
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GovernmentSchemes> query = cb.createQuery(GovernmentSchemes.class);
        Root<GovernmentSchemes> scheme = query.from(GovernmentSchemes.class);

        List<GovernmentSchemes> allschemes = findAllSchemes();
        
        for(GovernmentSchemes gs : allschemes) {
        	System.out.println("scheme"+ gs);
        }
        
        List<Predicate> predicates = new ArrayList<>();

     // Gender filter (Handles Male, Female, Other, an	d All)
        predicates.add(cb.or(
            cb.equal(scheme.get("gender"), "ALL"), 
            cb.equal(scheme.get("gender"), user.getGender())
        ));

        // Caste filter (Handles GEN, OBC, SC, ST, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("caste"), "ALL"), 
            cb.equal(scheme.get("caste"), user.getCaste())
        ));

        // Minority filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("minority"), "ALL"), 
            cb.equal(scheme.get("minority"), user.getMinority())
        ));

        // Student filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("student"), "ALL"), 
            cb.equal(scheme.get("student"), user.getStudent())
        ));

        // Employment Status filter (Unemployed, Employed, Self-Employed, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("employmentStatus"), "ALL"), 
            cb.equal(scheme.get("employmentStatus"), user.getCurrentEmployment())
        ));

        // BPL filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("bpl"), "ALL"), 
            cb.equal(scheme.get("bpl"), user.getBpl()) 
        ));

        // Hardship filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("hardship"), "ALL"), 
            cb.equal(scheme.get("hardship"), user.getHardship()) 
        ));

        // Differently Abled filter (Handles Yes, No, All)
        predicates.add(cb.or(
            cb.equal(scheme.get("differentlyAbled"), "ALL"), 
            cb.equal(scheme.get("differentlyAbled"), user.getDifferentlyAbled()) 
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
        
        System.out.println(schemetypeID);

        predicates.add(cb.equal(scheme.get("schemeTypeId"), schemetypeID));
        
        query.select(scheme).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
 
		
	}
	
	public List<GovernmentSchemes> findAllSchemes() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GovernmentSchemes> query = cb.createQuery(GovernmentSchemes.class);
        Root<GovernmentSchemes> scheme = query.from(GovernmentSchemes.class);

        query.select(scheme); // Select all schemes

        return entityManager.createQuery(query).getResultList();
    }
	
}
