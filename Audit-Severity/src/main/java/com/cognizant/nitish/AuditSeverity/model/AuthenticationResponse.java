package com.cognizant.nitish.AuditSeverity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuthenticationResponse {
	private String name;
	private String projectName;
	private boolean isValid;
}
