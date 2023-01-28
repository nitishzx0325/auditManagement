package com.cognizant.nitish.AuditSeverity.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.cognizant.nitish.AuditSeverity.model.AuditBenchmark;
import com.cognizant.nitish.AuditSeverity.model.AuditDetail;
import com.cognizant.nitish.AuditSeverity.model.AuditQuestion;
import com.cognizant.nitish.AuditSeverity.model.AuditRequest;
import com.cognizant.nitish.AuditSeverity.model.AuditResponse;
import com.cognizant.nitish.AuditSeverity.service.AuditResponseService;
import com.cognizant.nitish.AuditSeverity.service.AuthorizationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuditSeverityController.class, AuditRequest.class})
@ExtendWith(SpringExtension.class)
class AuditSeverityControllerTest {
    @Autowired
    private AuditRequest auditRequest;

    @MockBean
    private AuditResponseService auditResponseService;

    @Autowired
    private AuditSeverityController auditSeverityController;

    @MockBean
    private AuthorizationService authorizationService;

    /**
     * Method under test: {@link AuditSeverityController#auditSeverity(String, AuditRequest)}
     */
    @Test
    void testAuditSeverity() throws Exception {
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setAuditId(123);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse.setCreationDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        auditResponse.setManagerName("Manager Name");
        auditResponse.setProjectExecutionStatus("Project Execution Status");
        auditResponse.setProjectName("Project Name");
        auditResponse.setRemedialActionDuration("Remedial Action Duration");

        AuditResponse auditResponse1 = new AuditResponse();
        auditResponse1.setAuditId(123);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse1.setCreationDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        auditResponse1.setManagerName("Manager Name");
        auditResponse1.setProjectExecutionStatus("Project Execution Status");
        auditResponse1.setProjectName("Project Name");
        auditResponse1.setRemedialActionDuration("Remedial Action Duration");
        when(auditResponseService.getAuditResponse((List<AuditBenchmark>) any(), (String) any(),
                (List<AuditQuestion>) any())).thenReturn(auditResponse);
        when(auditResponseService.saveAuditResponse((AuditResponse) any(), (AuditRequest) any()))
                .thenReturn(auditResponse1);
        when(authorizationService.validateJwt((String) any())).thenReturn(true);

        AuditRequest auditRequest1 = new AuditRequest();
        auditRequest1.setAuditDetail(new AuditDetail());
        auditRequest1.setManagerName("Manager Name");
        auditRequest1.setProjectName("Project Name");
        String content = (new ObjectMapper()).writeValueAsString(auditRequest1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/severity/ProjectExecutionStatus")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(auditSeverityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"auditId\":123,\"managerName\":\"Manager Name\",\"projectName\":\"Project Name\",\"creationDateTime\":0,"
                                        + "\"projectExecutionStatus\":\"Project Execution Status\",\"remedialActionDuration\":\"Remedial Action"
                                        + " Duration\"}"));
    }

    /**
     * Method under test: {@link AuditSeverityController#auditSeverity(String, AuditRequest)}
     */
    @Test
    void testAuditSeverity2() throws Exception {
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setAuditId(123);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse.setCreationDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        auditResponse.setManagerName("Manager Name");
        auditResponse.setProjectExecutionStatus("Project Execution Status");
        auditResponse.setProjectName("Project Name");
        auditResponse.setRemedialActionDuration("Remedial Action Duration");

        AuditResponse auditResponse1 = new AuditResponse();
        auditResponse1.setAuditId(123);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse1.setCreationDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        auditResponse1.setManagerName("Manager Name");
        auditResponse1.setProjectExecutionStatus("Project Execution Status");
        auditResponse1.setProjectName("Project Name");
        auditResponse1.setRemedialActionDuration("Remedial Action Duration");
        when(auditResponseService.getAuditResponse((List<AuditBenchmark>) any(), (String) any(),
                (List<AuditQuestion>) any())).thenReturn(auditResponse);
        when(auditResponseService.saveAuditResponse((AuditResponse) any(), (AuditRequest) any()))
                .thenReturn(auditResponse1);
        when(authorizationService.validateJwt((String) any())).thenReturn(false);

        AuditRequest auditRequest1 = new AuditRequest();
        auditRequest1.setAuditDetail(new AuditDetail());
        auditRequest1.setManagerName("Manager Name");
        auditRequest1.setProjectName("Project Name");
        String content = (new ObjectMapper()).writeValueAsString(auditRequest1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/severity/ProjectExecutionStatus")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(auditSeverityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isForbidden())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"auditId\":0,\"managerName\":null,\"projectName\":null,\"creationDateTime\":null,\"projectExecutionStatus\""
                                        + ":null,\"remedialActionDuration\":null}"));
    }

    /**
     * Method under test: {@link AuditSeverityController#auditSeverity(String, AuditRequest)}
     */
    @Test
    void testAuditSeverity3() throws Exception {
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setAuditId(123);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse.setCreationDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        auditResponse.setManagerName("Manager Name");
        auditResponse.setProjectExecutionStatus("Project Execution Status");
        auditResponse.setProjectName("Project Name");
        auditResponse.setRemedialActionDuration("Remedial Action Duration");

        AuditResponse auditResponse1 = new AuditResponse();
        auditResponse1.setAuditId(123);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse1.setCreationDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        auditResponse1.setManagerName("Manager Name");
        auditResponse1.setProjectExecutionStatus("Project Execution Status");
        auditResponse1.setProjectName("Project Name");
        auditResponse1.setRemedialActionDuration("Remedial Action Duration");
        when(auditResponseService.getAuditResponse((List<AuditBenchmark>) any(), (String) any(),
                (List<AuditQuestion>) any())).thenReturn(auditResponse);
        when(auditResponseService.saveAuditResponse((AuditResponse) any(), (AuditRequest) any()))
                .thenReturn(auditResponse1);
        when(authorizationService.validateJwt((String) any())).thenReturn(true);

        AuditRequest auditRequest1 = new AuditRequest();
        auditRequest1.setAuditDetail(new AuditDetail());
        auditRequest1.setManagerName("Manager Name");
        auditRequest1.setProjectName("Project Name");
        String content = (new ObjectMapper()).writeValueAsString(auditRequest1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/severity/ProjectExecutionStatus")
                .header("Authorization", "")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(auditSeverityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isForbidden())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"auditId\":0,\"managerName\":null,\"projectName\":null,\"creationDateTime\":null,\"projectExecutionStatus\""
                                        + ":null,\"remedialActionDuration\":null}"));
    }

    /**
     * Method under test: {@link AuditSeverityController#healthCheck()}
     */
    @Test
    void testHealthCheck() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/severity/health-check");
        MockMvcBuilders.standaloneSetup(auditSeverityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Severity Microservice is Active"));
    }

    /**
     * Method under test: {@link AuditSeverityController#healthCheck()}
     */
    @Test
    void testHealthCheck2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/severity/health-check");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(auditSeverityController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Severity Microservice is Active"));
    }
}

