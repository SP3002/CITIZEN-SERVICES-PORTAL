package com.citizenservicesportal.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        
        	.cors( cors -> cors.configurationSource( request -> {
        		
        		CorsConfiguration config  = new CorsConfiguration();
        		config.setAllowedOrigins(List.of("http://localhost:3000"));
        		config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        		config.setAllowedHeaders(List.of("*"));
        		config.setAllowCredentials(true);
        		return config;
        		
        	})) 
        	.csrf(csrf -> csrf.disable())
        	.authorizeHttpRequests(auth -> auth
        			.requestMatchers("/CitizenServicesPortal/**").permitAll()
        			.anyRequest().authenticated()
        			)
        	.logout(logout -> logout
        			.logoutUrl("/CitizenServicesPortal/logout")
        			.logoutSuccessHandler( (request, response, authentication) -> {
        				response.setStatus(HttpServletResponse.SC_OK);
        				response.getWriter().write("{\"message\":\"Logout Successful\"}");
        				response.setContentType("application/json");
        				response.getWriter().flush();
        			} )
        			.invalidateHttpSession(true)
        			.clearAuthentication(true)
        			.logoutSuccessUrl("/CitizenServicesPortal/login")
        			.permitAll()
        			)
        	.sessionManagement( session -> session
        			.maximumSessions(1)
        	);
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Password encoder bean
    }

    // Define a UserDetailsService to load user details from a database or hardcoded user
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> User
                .withUsername("csp")
                .password(passwordEncoder().encode("csp123"))  // Store the encoded password
                .roles("USER")
                .build();
    }
}
