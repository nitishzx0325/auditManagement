package com.cognizant.nitish.AuditSeverity.service;


public interface AuthorizationService {
	
	public boolean validateJwt(String jwt);
}
