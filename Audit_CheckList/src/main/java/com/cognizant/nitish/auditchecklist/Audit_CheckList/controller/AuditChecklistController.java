package com.cognizant.nitish.auditchecklist.Audit_CheckList.controller;

import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuditType;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.Question;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.service.AuthorizationService;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.service.QuestionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/checklist")
@CrossOrigin(origins = "*")
public class AuditChecklistController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	Logger logger = LoggerFactory.getLogger("Checklist-Controller-Logger");
	
	// Endpoint for retrieving the questions from the DB 
	@RequestMapping(value = "/AuditCheckListQuestions", method = {RequestMethod.GET, RequestMethod.POST} )
	public List<Question> auditCheckListQuestions(@RequestHeader("Authorization") String jwt, @RequestBody AuditType auditType) {
		List<Question> questions = new ArrayList<Question>();
		
		logger.info("from header JWT :: " + jwt);
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {	
			questions = questionService.getQuestionsByAuditType(auditType);
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
		}
		return questions;
	}
	
	// Endpoint to check if t	he microservice is active
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Audit Checklist Microservice is Active";
	}
}
