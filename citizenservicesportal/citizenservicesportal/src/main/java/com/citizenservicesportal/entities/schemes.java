package com.citizenservicesportal.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schemes")
public class schemes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schemeid")
	private Integer schemeID;
	
	@Column(name = "schemename", nullable = false)
	@NotBlank(message = "Please enter a Name of the Scheme. CANNOT BE EMPTY")
	private String schemeName;
	
	@Column(name = "departmentname", nullable = false)
	@NotBlank(message = "ENTER THE NAME OF THE DEPARTMENT")
	private String departmentName;
	
	@Column(name = "eligibility", nullable = false)
	@NotBlank(message = "enter the eligibility details")
	private String eligibility;
	
	@Column(name = "dateofimplementation", nullable = false)
	@NotBlank(message = "The Date of Implementation is MANDATORY")
	@Temporal(TemporalType.DATE)
	private Date dateOfImplementation;
	
	@Column(name = "schemeDescription", nullable = false)
	@NotBlank(message = "*Required")
	private String schemeDescription;
	
	@Column(name = "targetaudience", nullable = false)
	@NotBlank(message = "*Required")
	private String targetAudience;
	
	@Column(name = "budgetallocation", nullable = false)
	@NotBlank(message = "*Required")
	private Float budgetAllocation;
	
	@Column(name = "status", nullable = false)
	@NotBlank(message = "*Required")
	@Pattern(regexp = "ACTIVE|DEACTIVE", message = "should be only ACTIVE|DEACTIVE")
	private String status;
	
	@Column(name = "applicationmode", nullable = false)
	@NotBlank(message = "*Required")
	private String applicationMode;
	
	@Column(name = "website", nullable = false)
	@NotBlank(message = "*Required")
	private String website;
	
}
