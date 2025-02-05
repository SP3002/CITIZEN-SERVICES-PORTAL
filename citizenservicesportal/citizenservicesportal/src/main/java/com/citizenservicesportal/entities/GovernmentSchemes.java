package com.citizenservicesportal.entities;

import com.citizenservicesportal.enums.ApplicationMode;
import com.citizenservicesportal.enums.Caste;
import com.citizenservicesportal.enums.EmploymentStatus;
import com.citizenservicesportal.enums.Gender;
import com.citizenservicesportal.enums.Status;
import com.citizenservicesportal.enums.YesNo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "government_schemes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GovernmentSchemes {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schemeId;

    @Column(nullable = false, length = 255)
    private String schemeName;

    @Column(nullable = false, length = 255)
    private String ministry;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String eligibility;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationMode applicationMode;

    @Column(nullable = false, length = 500)
    private String websiteUrl;

    @Column(nullable = false)
    private Integer schemeTypeId;

    @Column(nullable = false, length = 100)
    private String state;

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.ALL;

    @Enumerated(EnumType.STRING)
    private Caste caste = Caste.ALL;

    @Enumerated(EnumType.STRING)
    private YesNo minority = YesNo.ALL;

    @Enumerated(EnumType.STRING)
    private YesNo student = YesNo.ALL;

    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus = EmploymentStatus.UNEMPLOYED;

    @Enumerated(EnumType.STRING)
    private YesNo bpl = YesNo.ALL;

    @Enumerated(EnumType.STRING)
    private YesNo hardship = YesNo.NO;

    @Enumerated(EnumType.STRING)
    private YesNo differentlyAbled = YesNo.NO;

    private Double minIncome;

    private Double maxIncome;
	
}
