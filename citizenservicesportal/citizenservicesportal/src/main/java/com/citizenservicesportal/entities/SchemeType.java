package com.citizenservicesportal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "schemetype")
public class SchemeType {

	@Id
	@Column(name="schemetypeid")
	public Integer schemetypeid;
	
	@Column(name="schemetype")
	public String schemeType;
	
}
