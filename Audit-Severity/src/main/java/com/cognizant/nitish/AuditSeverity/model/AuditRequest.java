package com.cognizant.nitish.AuditSeverity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditRequest {
	
	private String projectName;
	private String managerName;
	private AuditDetail auditDetail;
	
}
