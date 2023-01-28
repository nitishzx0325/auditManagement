package com.cognizant.nitish.AuditSeverity.feign;

import com.cognizant.nitish.AuditSeverity.model.AuditQuestion;

import com.cognizant.nitish.AuditSeverity.model.AuditType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "${ms.checklist}", name="auditChecklist")
public interface AuditCheckListFeign {
	
	@RequestMapping(value = "/AuditCheckListQuestions", method = RequestMethod.POST )
	public List<AuditQuestion> auditCheckListQuestions(@RequestHeader("Authorization") String jwt, @RequestBody AuditType auditType);
	
}
