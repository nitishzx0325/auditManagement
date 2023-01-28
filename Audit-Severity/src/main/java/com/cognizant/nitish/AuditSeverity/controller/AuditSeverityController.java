package com.cognizant.nitish.AuditSeverity.controller;


import com.cognizant.nitish.AuditSeverity.model.*;
import com.cognizant.nitish.AuditSeverity.service.AuditResponseService;
import com.cognizant.nitish.AuditSeverity.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/severity")
@CrossOrigin(origins = "*")
public class AuditSeverityController {
	

	
	@Autowired
	private AuditResponseService auditResponseService;
	
	@Autowired
	private AuthorizationService authorizationService;

	Logger logger = LoggerFactory.getLogger("Severity-Controller-Logger");

	//This is to check the microservice is working or not 
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Audit Severity Microservice is Active";
	}
	
	//This is to check the severity of the audit and it returns the execution status of the project
	@PostMapping("/ProjectExecutionStatus")
	public ResponseEntity<?> auditSeverity(@RequestHeader("Authorization") String jwt,
				@RequestBody AuditRequest auditRequest){

		AuditResponse auditResponse = new AuditResponse();
		
		ResponseEntity<AuditResponse> response= null;
		
		// checking if the jwt is valid or not
		// creating auditResponse according to auditRequest
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {				
			logger.info("Successfully validated the JWT :: " + jwt);
			
			// getting benchmark list from Benchmark-MS
//			List<AuditBenchmark> benchmarkList = auditBenchmarkFeign.getAuditBenchmark(jwt);
			List<AuditBenchmark> list= Arrays.asList(
					new AuditBenchmark(1,"Internal",3),
					new AuditBenchmark(2,"SOX",2));


			AuditType auditType = new AuditType();
			
			auditType.setAuditType(auditRequest.getAuditDetail().getAuditType());	// setting auditType
			
			// getting responses back from RequestBody
			List<AuditQuestion> questionResponses = auditRequest.getAuditDetail().getAuditQuestions();
			
			// create Audit-response
			auditResponse = auditResponseService.getAuditResponse( list,auditType.getAuditType(), questionResponses);

			// saving response in DB
			auditResponse = auditResponseService.saveAuditResponse(auditResponse,auditRequest);
			
			logger.info("AuditResponse successfully created!!");
			
			response = new ResponseEntity<AuditResponse>(auditResponse, HttpStatus.OK);
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
			response = new ResponseEntity<>(auditResponse,HttpStatus.FORBIDDEN);
		}
		return response;
		
	}
}
