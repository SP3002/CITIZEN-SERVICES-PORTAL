package com.citizenservicesportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.citizenservicesportal.repositories")
@EntityScan(basePackages = "com.citizenservicesportal.entities")
@SpringBootApplication(scanBasePackages = "com.citizenservicesportal")
//@EnableDiscoveryClient
public class CitizenServicesPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizenServicesPortalApplication.class, args);
	}

}
