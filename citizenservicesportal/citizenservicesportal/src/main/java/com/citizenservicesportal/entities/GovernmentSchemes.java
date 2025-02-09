package com.citizenservicesportal.entities;

import com.citizenservicesportal.enums.Area;
import com.citizenservicesportal.enums.Caste;
import com.citizenservicesportal.enums.EmploymentStatus;
import com.citizenservicesportal.enums.Gender;
import com.citizenservicesportal.enums.MaritalStatus;
import com.citizenservicesportal.enums.YesNo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "scheme")
public class GovernmentSchemes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schemeid")
    private Integer schemeId;

    @Column(name = "schemename", nullable = false, length = 255)
    @NotBlank(message = "Scheme Name is required")
    private String schemeName;
    
    @ManyToOne
    @JoinColumn(name = "schemetypeid", nullable = false) // Foreign key column
    private SchemeType schemeType;

    @Column(name="schemeurl")
    private String schemeURL;
    
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "Description is required")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligiblegender")
    private Gender eligibleGender; //MALE, FEMALE, TRANSGENDER, ALL;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligiblemaritalstatus")
    private MaritalStatus eligibleMaritalStatus; //MARRIED, UNMARRIED,DIVORCED,WIDOW;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligiblearea")
    private Area eligibleArea; //RURAL, URBAN;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligiblecaste")
    private Caste eligibleCaste; //GEN, OBC, SC, ST,ALL;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligibledifferentlyabled")
    private YesNo eligibleDifferentlyAbled; //YES, NO, ALL;
    

    @Enumerated(EnumType.STRING)
    @Column(name = "eligibleminority")
    private YesNo eligibleMinority; //YES, NO, ALL;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligiblestudent")
    private YesNo eligibleStudent; //YES, NO, ALL;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligibleemploymentstatus")
    private EmploymentStatus eligibleEmploymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligiblebpl")
    private YesNo eligibleBPL; //YES, NO, ALL;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligiblehardship")
    private YesNo eligibleHardship; //YES, NO, ALL;


    @Column(name = "minfamilyincome")
    private Double minFamilyIncome;

    @Column(name = "maxfamilyincome")
    private Double maxFamilyIncome;

    @Column(name = "minage")
    private Integer minAge;

    @Column(name = "maxage")
    private Integer maxAge;

    @Column(name = "othercriteria", columnDefinition = "TEXT")
    private String otherCriteria;

}