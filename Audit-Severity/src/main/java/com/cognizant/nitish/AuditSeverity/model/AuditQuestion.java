package com.cognizant.nitish.AuditSeverity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditQuestion {
	
	private int questionId;
	private String question;
	private String auditType;
	private String response;
	
}
