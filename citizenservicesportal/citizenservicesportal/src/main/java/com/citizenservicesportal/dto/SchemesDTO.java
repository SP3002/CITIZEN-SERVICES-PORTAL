package com.citizenservicesportal.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchemesDTO {

	private Integer SchemeID;
	private String SchemeName;
	private String DepartmentName;
	private String Eligibility;
	private Date DateofImplementation;
	private String SchemeDescription;
	private Float BudgetAllocation;
	private String Status;
	private String ApplicationMode;
	private String Website;
	
}
