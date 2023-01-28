package com.cognizant.nitish.auditchecklist.Audit_CheckList.repository;

import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

    // Retrieves the data from the database by searching using the auditType
    @Query(value = "SELECT q FROM Question q WHERE q.auditType=?1")
    List<Question> getQuestionsByAuditType(String auditType);

}