package com.cognizant.nitish.AuditSeverity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.nitish.AuditSeverity.model.AuditBenchmark;
import com.cognizant.nitish.AuditSeverity.model.AuditQuestion;
import com.cognizant.nitish.AuditSeverity.model.AuditRequest;
import com.cognizant.nitish.AuditSeverity.model.AuditResponse;
import com.cognizant.nitish.AuditSeverity.repository.AuditResponseRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuditResponseServiceImpl.class,
        AuditRequest.class})
@ExtendWith(SpringExtension.class)
class AuditResponseServiceImplTest {
    @Autowired
    private AuditRequest auditRequest;

    @MockBean
    private AuditResponseRepo auditResponseRepo;

    @Autowired
    private AuditResponseServiceImpl auditResponseServiceImpl;

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAuditResponse() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:359)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.createAuditResponse(AuditResponseServiceImpl.java:28)
        //   In order to prevent createAuditResponse(int, List)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAuditResponse(int, List).
        //   See https://diff.blue/R013 to resolve this issue.

        auditResponseServiceImpl.createAuditResponse(1, new ArrayList<>());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    void testCreateAuditResponse2() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualCreateAuditResponseResult = auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    void testCreateAuditResponse3() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "No", "No", "No"));
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualCreateAuditResponseResult = auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    void testCreateAuditResponse4() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Internal", "Response"));
        AuditResponse actualCreateAuditResponseResult = auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("No action needed", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("GREEN", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    void testCreateAuditResponse5() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "SOX", "Response"));
        AuditResponse actualCreateAuditResponseResult = auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("No action needed", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("GREEN", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    void testCreateAuditResponse6() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "No", "No", "No"));
        auditQuestionList.add(new AuditQuestion(123, "No", "No", "No"));
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualCreateAuditResponseResult = auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    void testCreateAuditResponse7() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "No", "Internal", "No"));
        auditQuestionList.add(new AuditQuestion(123, "No", "No", "No"));
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualCreateAuditResponseResult = auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("Action to be taken in 2 weeks", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAuditResponse8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equalsIgnoreCase(String)" because the return value of "com.cognizant.nitish.AuditSeverity.model.AuditQuestion.getResponse()" is null
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.countNos(AuditResponseServiceImpl.java:62)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.createAuditResponse(AuditResponseServiceImpl.java:29)
        //   In order to prevent createAuditResponse(int, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAuditResponse(int, List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion());
        auditResponseServiceImpl.createAuditResponse(1, auditQuestionList);
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAuditResponse9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cognizant.nitish.AuditSeverity.model.AuditQuestion.getAuditType()" because the return value of "com.diffblue.cover.agent.readwrite.RuntimeWrappers.list$get(java.util.List, int)" is null
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.createAuditResponse(AuditResponseServiceImpl.java:28)
        //   In order to prevent createAuditResponse(int, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAuditResponse(int, List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(null);
        auditResponseServiceImpl.createAuditResponse(1, auditQuestionList);
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#createAuditResponse(int, List)}
     */
    @Test
    void testCreateAuditResponse10() {
        AuditQuestion auditQuestion = mock(AuditQuestion.class);
        when(auditQuestion.getAuditType()).thenReturn("Audit Type");
        when(auditQuestion.getResponse()).thenReturn("Response");

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(auditQuestion);
        AuditResponse actualCreateAuditResponseResult = auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
        verify(auditQuestion).getAuditType();
        verify(auditQuestion).getResponse();
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#countNos(List)}
     */
    @Test
    void testCountNos() {
        assertEquals(0, auditResponseServiceImpl.countNos(new ArrayList<>()));
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#countNos(List)}
     */
    @Test
    void testCountNos2() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        assertEquals(0, auditResponseServiceImpl.countNos(auditQuestionList));
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#countNos(List)}
     */
    @Test
    void testCountNos3() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "No", "No", "No"));
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        assertEquals(1, auditResponseServiceImpl.countNos(auditQuestionList));
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#countNos(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCountNos4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equalsIgnoreCase(String)" because the return value of "com.cognizant.nitish.AuditSeverity.model.AuditQuestion.getResponse()" is null
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.countNos(AuditResponseServiceImpl.java:62)
        //   In order to prevent countNos(List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   countNos(List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion());
        auditResponseServiceImpl.countNos(auditQuestionList);
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#countNos(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCountNos5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cognizant.nitish.AuditSeverity.model.AuditQuestion.getResponse()" because "q" is null
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.countNos(AuditResponseServiceImpl.java:62)
        //   In order to prevent countNos(List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   countNos(List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(null);
        auditResponseServiceImpl.countNos(auditQuestionList);
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#countNos(List)}
     */
    @Test
    void testCountNos6() {
        AuditQuestion auditQuestion = mock(AuditQuestion.class);
        when(auditQuestion.getResponse()).thenReturn("Response");

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(auditQuestion);
        assertEquals(0, auditResponseServiceImpl.countNos(auditQuestionList));
        verify(auditQuestion).getResponse();
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuditResponse() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:359)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.createAuditResponse(AuditResponseServiceImpl.java:28)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.getAuditResponse(AuditResponseServiceImpl.java:79)
        //   In order to prevent getAuditResponse(List, String, List)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuditResponse(List, String, List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditBenchmark> benchmarkList = new ArrayList<>();
        auditResponseServiceImpl.getAuditResponse(benchmarkList, "Audit Type", new ArrayList<>());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuditResponse2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:359)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.createAuditResponse(AuditResponseServiceImpl.java:28)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.getAuditResponse(AuditResponseServiceImpl.java:79)
        //   In order to prevent getAuditResponse(List, String, List)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuditResponse(List, String, List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
        auditBenchmarkList.add(new AuditBenchmark(123, "Audit Type", 1));
        auditResponseServiceImpl.getAuditResponse(auditBenchmarkList, "Audit Type", new ArrayList<>());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuditResponse3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:359)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.createAuditResponse(AuditResponseServiceImpl.java:28)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.getAuditResponse(AuditResponseServiceImpl.java:79)
        //   In order to prevent getAuditResponse(List, String, List)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuditResponse(List, String, List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
        auditBenchmarkList.add(new AuditBenchmark(123, "com.cognizant.nitish.AuditSeverity.model.AuditBenchmark", 1));
        auditResponseServiceImpl.getAuditResponse(auditBenchmarkList, "Audit Type", new ArrayList<>());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    void testGetAuditResponse4() {
        ArrayList<AuditBenchmark> benchmarkList = new ArrayList<>();

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualAuditResponse = auditResponseServiceImpl.getAuditResponse(benchmarkList, "Audit Type",
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualAuditResponse.getRemedialActionDuration());
        assertEquals("RED", actualAuditResponse.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    void testGetAuditResponse5() {
        ArrayList<AuditBenchmark> benchmarkList = new ArrayList<>();

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "No", "No", "No"));
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualAuditResponse = auditResponseServiceImpl.getAuditResponse(benchmarkList, "Audit Type",
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualAuditResponse.getRemedialActionDuration());
        assertEquals("RED", actualAuditResponse.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    void testGetAuditResponse6() {
        ArrayList<AuditBenchmark> benchmarkList = new ArrayList<>();

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Internal", "Response"));
        AuditResponse actualAuditResponse = auditResponseServiceImpl.getAuditResponse(benchmarkList, "Audit Type",
                auditQuestionList);
        assertEquals("No action needed", actualAuditResponse.getRemedialActionDuration());
        assertEquals("GREEN", actualAuditResponse.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    void testGetAuditResponse7() {
        ArrayList<AuditBenchmark> benchmarkList = new ArrayList<>();

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "SOX", "Response"));
        AuditResponse actualAuditResponse = auditResponseServiceImpl.getAuditResponse(benchmarkList, "Audit Type",
                auditQuestionList);
        assertEquals("No action needed", actualAuditResponse.getRemedialActionDuration());
        assertEquals("GREEN", actualAuditResponse.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    void testGetAuditResponse8() {
        ArrayList<AuditBenchmark> benchmarkList = new ArrayList<>();

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        auditQuestionList.add(new AuditQuestion(123, "No", "Internal", "No"));
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualAuditResponse = auditResponseServiceImpl.getAuditResponse(benchmarkList, "Audit Type",
                auditQuestionList);
        assertEquals("Action to be taken in 2 weeks", actualAuditResponse.getRemedialActionDuration());
        assertEquals("RED", actualAuditResponse.getProjectExecutionStatus());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuditResponse9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equalsIgnoreCase(String)" because the return value of "com.cognizant.nitish.AuditSeverity.model.AuditBenchmark.getAuditType()" is null
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.getAuditResponse(AuditResponseServiceImpl.java:74)
        //   In order to prevent getAuditResponse(List, String, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuditResponse(List, String, List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
        auditBenchmarkList.add(new AuditBenchmark());
        auditResponseServiceImpl.getAuditResponse(auditBenchmarkList, "Audit Type", new ArrayList<>());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuditResponse10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cognizant.nitish.AuditSeverity.model.AuditBenchmark.getAuditType()" because "ab" is null
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.getAuditResponse(AuditResponseServiceImpl.java:74)
        //   In order to prevent getAuditResponse(List, String, List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuditResponse(List, String, List).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
        auditBenchmarkList.add(null);
        auditResponseServiceImpl.getAuditResponse(auditBenchmarkList, "Audit Type", new ArrayList<>());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#getAuditResponse(List, String, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuditResponse11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:359)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.createAuditResponse(AuditResponseServiceImpl.java:28)
        //       at com.cognizant.nitish.AuditSeverity.service.AuditResponseServiceImpl.getAuditResponse(AuditResponseServiceImpl.java:79)
        //   In order to prevent getAuditResponse(List, String, List)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuditResponse(List, String, List).
        //   See https://diff.blue/R013 to resolve this issue.

        AuditBenchmark auditBenchmark = mock(AuditBenchmark.class);
        when(auditBenchmark.getBenchmarkNoAnswers()).thenReturn(1);
        when(auditBenchmark.getAuditType()).thenReturn("Audit Type");

        ArrayList<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
        auditBenchmarkList.add(auditBenchmark);
        auditResponseServiceImpl.getAuditResponse(auditBenchmarkList, "Audit Type", new ArrayList<>());
    }

    /**
     * Method under test: {@link AuditResponseServiceImpl#saveAuditResponse(AuditResponse, AuditRequest)}
     */
    @Test
    void testSaveAuditResponse() {
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setAuditId(123);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse.setCreationDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        auditResponse.setManagerName("Manager Name");
        auditResponse.setProjectExecutionStatus("Project Execution Status");
        auditResponse.setProjectName("Project Name");
        auditResponse.setRemedialActionDuration("Remedial Action Duration");
        when(auditResponseRepo.save((AuditResponse) any())).thenReturn(auditResponse);

        AuditResponse auditResponse1 = new AuditResponse();
        auditResponse1.setAuditId(123);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse1.setCreationDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        auditResponse1.setManagerName("Manager Name");
        auditResponse1.setProjectExecutionStatus("Project Execution Status");
        auditResponse1.setProjectName("Project Name");
        auditResponse1.setRemedialActionDuration("Remedial Action Duration");
        assertSame(auditResponse, auditResponseServiceImpl.saveAuditResponse(auditResponse1, auditRequest));
        verify(auditResponseRepo).save((AuditResponse) any());
        assertNull(auditResponse1.getProjectName());
        assertNull(auditResponse1.getManagerName());
    }
}

