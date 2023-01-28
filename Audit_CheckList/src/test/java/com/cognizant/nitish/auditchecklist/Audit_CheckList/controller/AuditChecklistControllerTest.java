package com.cognizant.nitish.auditchecklist.Audit_CheckList.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuditType;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.service.AuthorizationService;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.service.QuestionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuditChecklistController.class})
@ExtendWith(SpringExtension.class)
class AuditChecklistControllerTest {
    @Autowired
    private AuditChecklistController auditChecklistController;

    @MockBean
    private AuthorizationService authorizationService;

    @MockBean
    private QuestionService questionService;

    /**
     * Method under test: {@link AuditChecklistController#auditCheckListQuestions(String, AuditType)}
     */
    @Test
    void testAuditCheckListQuestions() throws Exception {
        when(authorizationService.validateJwt((String) any())).thenReturn(true);
        when(questionService.getQuestionsByAuditType((AuditType) any())).thenReturn(new ArrayList<>());

        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");
        String content = (new ObjectMapper()).writeValueAsString(auditType);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checklist/AuditCheckListQuestions")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(auditChecklistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuditChecklistController#auditCheckListQuestions(String, AuditType)}
     */
    @Test
    void testAuditCheckListQuestions2() throws Exception {
        when(authorizationService.validateJwt((String) any())).thenReturn(false);
        when(questionService.getQuestionsByAuditType((AuditType) any())).thenReturn(new ArrayList<>());

        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");
        String content = (new ObjectMapper()).writeValueAsString(auditType);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checklist/AuditCheckListQuestions")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(auditChecklistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuditChecklistController#auditCheckListQuestions(String, AuditType)}
     */
    @Test
    void testAuditCheckListQuestions3() throws Exception {
        when(authorizationService.validateJwt((String) any())).thenReturn(true);
        when(questionService.getQuestionsByAuditType((AuditType) any())).thenReturn(new ArrayList<>());

        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");
        String content = (new ObjectMapper()).writeValueAsString(auditType);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checklist/AuditCheckListQuestions")
                .header("Authorization", "")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(auditChecklistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuditChecklistController#healthCheck()}
     */
    @Test
    void testHealthCheck() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checklist/health-check");
        MockMvcBuilders.standaloneSetup(auditChecklistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Checklist Microservice is Active"));
    }

    /**
     * Method under test: {@link AuditChecklistController#healthCheck()}
     */
    @Test
    void testHealthCheck2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/checklist/health-check");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(auditChecklistController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Checklist Microservice is Active"));
    }
}

