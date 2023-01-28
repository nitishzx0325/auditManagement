package com.cognizant.nitish.auditchecklist.Audit_CheckList.service;

import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuditType;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.Question;


import java.util.List;

public interface QuestionService {

	public List<Question> getQuestionsByAuditType(AuditType auditType);
}
