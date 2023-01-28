package com.cognizant.nitish.auditchecklist.Audit_CheckList.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuditType;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.Question;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.repository.QuestionRepo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {QuestionServiceImpl.class})
@ExtendWith(SpringExtension.class)
class QuestionServiceImplTest {
    @MockBean
    private QuestionRepo questionRepo;

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    /**
     * Method under test: {@link QuestionServiceImpl#getQuestionsByAuditType(AuditType)}
     */
    @Test
    void testGetQuestionsByAuditType() {
        ArrayList<Question> questionList = new ArrayList<>();
        when(questionRepo.getQuestionsByAuditType((String) any())).thenReturn(questionList);
        List<Question> actualQuestionsByAuditType = questionServiceImpl
                .getQuestionsByAuditType(new AuditType("Audit Type"));
        assertSame(questionList, actualQuestionsByAuditType);
        assertTrue(actualQuestionsByAuditType.isEmpty());
        verify(questionRepo).getQuestionsByAuditType((String) any());
    }

    /**
     * Method under test: {@link QuestionServiceImpl#getQuestionsByAuditType(AuditType)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetQuestionsByAuditType2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuditType.getAuditType()" because "auditType" is null
        //       at com.cognizant.nitish.auditchecklist.Audit_CheckList.service.QuestionServiceImpl.getQuestionsByAuditType(QuestionServiceImpl.java:20)
        //   In order to prevent getQuestionsByAuditType(AuditType)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getQuestionsByAuditType(AuditType).
        //   See https://diff.blue/R013 to resolve this issue.

        when(questionRepo.getQuestionsByAuditType((String) any())).thenReturn(new ArrayList<>());
        questionServiceImpl.getQuestionsByAuditType(null);
    }
}

