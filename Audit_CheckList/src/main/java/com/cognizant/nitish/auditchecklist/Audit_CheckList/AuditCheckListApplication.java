package com.cognizant.nitish.auditchecklist.Audit_CheckList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuditCheckListApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditCheckListApplication.class, args);
	}

}
