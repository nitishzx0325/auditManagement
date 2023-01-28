package com.cognizant.nitish.AuditSeverity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AuditDetail {
	
	private String auditType;
	private Date auditDate;
	private List<AuditQuestion> auditQuestions;
}
