package com.cognizant.nitish.AuditSeverity.service;

import com.cognizant.nitish.AuditSeverity.feign.AuthorizationFeign;
import com.cognizant.nitish.AuditSeverity.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService{

	@Autowired
	private AuthorizationFeign authClient;
	
	@Override
	public boolean validateJwt(String jwt) {
		AuthenticationResponse authenticationResponse = authClient.validate(jwt).getBody();
		return authenticationResponse.isValid();
	}
	
	
}
