package com.cognizant.nitish.AuditSeverity.feign;

import com.cognizant.nitish.AuditSeverity.model.AuthenticationResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="Authorization-Ms", url = "${ms.auth}")
public interface AuthorizationFeign{

	@PostMapping("/validate")
	public ResponseEntity<AuthenticationResponse> validate(@RequestHeader("Authorization") String jwt);

}
