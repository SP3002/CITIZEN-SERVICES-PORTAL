package com.citizenservicesportal.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.citizenservicesportal.entities.GovernmentSchemes;
import com.citizenservicesportal.entities.UserDetails;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class SchemeSpecification {
    public static Specification<GovernmentSchemes> getEligibleSchemes(UserDetails user, Integer schemetypeid) {
        return (Root<GovernmentSchemes> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (schemetypeid != null) {
                predicates.add(cb.equal(root.get("schemeType").get("schemetypeid"), schemetypeid));
            }
            
            if (user.getGender() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleGender"), "ALL"),
                        cb.equal(root.get("eligibleGender"), user.getGender())
                ));
            }

            if (user.getMaritalStatus() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleMaritalStatus"), "ALL"),
                        cb.equal(root.get("eligibleMaritalStatus"), user.getMaritalStatus())
                ));
            }

            if (user.getArea() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleArea"), "ALL"),
                        cb.equal(root.get("eligibleArea"), user.getArea())
                ));
            }

            if (user.getCaste() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleCaste"), "ALL"),
                        cb.equal(root.get("eligibleCaste"), user.getCaste())
                ));
            }

            if (user.getDifferentlyAbled() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleDifferentlyAbled"), "ALL"),
                        cb.equal(root.get("eligibleDifferentlyAbled"), user.getDifferentlyAbled())
                ));
            }

            if (user.getMinority() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleMinority"), "ALL"),
                        cb.equal(root.get("eligibleMinority"), user.getMinority())
                ));
            }

            if (user.getStudent() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleStudent"), "ALL"),
                        cb.equal(root.get("eligibleStudent"), user.getStudent())
                ));
            }

            if (user.getCurrentEmployment() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleEmploymentStatus"), "ALL"),
                        cb.equal(root.get("eligibleEmploymentStatus"), user.getCurrentEmployment())
                ));
            }

            if (user.getBpl() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleBPL"), "ALL"),
                        cb.equal(root.get("eligibleBPL"), user.getBpl())
                ));
            }

            if (user.getHardship() != null) {
                predicates.add(cb.or(
                        cb.equal(root.get("eligibleHardship"), "ALL"),
                        cb.equal(root.get("eligibleHardship"), user.getHardship())
                ));
            }

            if (user.getFamilyIncome() != null) {
                predicates.add(cb.and(
                        cb.or(cb.isNull(root.get("minFamilyIncome")), cb.lessThanOrEqualTo(root.get("minFamilyIncome"), user.getFamilyIncome())),
                        cb.or(cb.isNull(root.get("maxFamilyIncome")), cb.greaterThanOrEqualTo(root.get("maxFamilyIncome"), user.getFamilyIncome()))
                ));
            }

//            if (user.getAge() != null) {
//                predicates.add(cb.and(
//                        cb.or(cb.isNull(root.get("minAge")), cb.lessThanOrEqualTo(root.get("minAge"), user.getAge())),
//                        cb.or(cb.isNull(root.get("maxAge")), cb.greaterThanOrEqualTo(root.get("maxAge"), user.getAge()))
//                ));
//            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
