package com.cognizant.nitish.AuditSeverity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name="audit_response")
@AllArgsConstructor
@NoArgsConstructor
public class AuditResponse {
	
	@Id
	@GeneratedValue
	private int auditId;
	private String managerName;
	private String projectName;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;
	
	private String projectExecutionStatus;
	private String remedialActionDuration;
	
	public void setCreationDateTime(Date creationDateTime2) {
		this.creationDateTime = creationDateTime2;
	}
	
}
