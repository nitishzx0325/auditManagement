package com.cognizant.nitish.AuditSeverity.service;


import com.cognizant.nitish.AuditSeverity.model.AuditBenchmark;
import com.cognizant.nitish.AuditSeverity.model.AuditQuestion;
import com.cognizant.nitish.AuditSeverity.model.AuditRequest;
import com.cognizant.nitish.AuditSeverity.model.AuditResponse;


import java.util.List;

public interface AuditResponseService {
	
	//public List<AuditResponse> getAuditResponses(List<AuditBenchmark> benchmarkList,List<AuditQuestion> questionListInternal,List<AuditQuestion> questionListSox);

	public AuditResponse getAuditResponse(List<AuditBenchmark> benchmarkList, String auditType,List<AuditQuestion> questionResponses);

	public AuditResponse saveAuditResponse(AuditResponse auditResponse, AuditRequest auditRequest);
}
