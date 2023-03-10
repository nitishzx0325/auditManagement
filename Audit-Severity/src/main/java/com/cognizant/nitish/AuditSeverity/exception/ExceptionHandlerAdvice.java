package com.cognizant.nitish.AuditSeverity.exception;



import com.cognizant.nitish.AuditSeverity.model.AuditResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	Logger logger = LoggerFactory.getLogger("Benchmark-Exception-Handler-Advice");
	
	// here it handles if any exception occurs during validation...
	// we we send a Invalid response to the Angular app if exception occurs
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		logger.error(e.getMessage());
		AuditResponse auditResponse = new AuditResponse();
		return new ResponseEntity<>(auditResponse, HttpStatus.OK);
	}
}
