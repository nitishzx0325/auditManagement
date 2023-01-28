package com.cognizant.nitish.auditchecklist.Audit_CheckList.service;


public interface AuthorizationService {
	
	public boolean validateJwt(String jwt);
}
