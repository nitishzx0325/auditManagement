package com.cognizant.nitish.auditchecklist.Audit_CheckList.service;

import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuditType;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.Question;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.repository.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	// Service for the Endpoint /AuditCheckListQuestions
	public List<Question> getQuestionsByAuditType(AuditType auditType){
		List<Question> qlist = questionRepo.getQuestionsByAuditType(auditType.getAuditType());
		return qlist;
	}

}
