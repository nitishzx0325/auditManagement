package com.cognizant.nitish.AuditSeverity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuditRequest.class})
@ExtendWith(SpringExtension.class)
class AuditRequestTest {
    @Autowired
    private AuditRequest auditRequest;

    /**
     * Method under test: {@link AuditRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(auditRequest.canEqual("Other"));
        assertTrue(auditRequest.canEqual(auditRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditRequest#AuditRequest()}
     *   <li>{@link AuditRequest#setAuditDetail(AuditDetail)}
     *   <li>{@link AuditRequest#setManagerName(String)}
     *   <li>{@link AuditRequest#setProjectName(String)}
     *   <li>{@link AuditRequest#toString()}
     *   <li>{@link AuditRequest#getAuditDetail()}
     *   <li>{@link AuditRequest#getManagerName()}
     *   <li>{@link AuditRequest#getProjectName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuditRequest actualAuditRequest = new AuditRequest();
        AuditDetail auditDetail = new AuditDetail();
        actualAuditRequest.setAuditDetail(auditDetail);
        actualAuditRequest.setManagerName("Manager Name");
        actualAuditRequest.setProjectName("Project Name");
        String actualToStringResult = actualAuditRequest.toString();
        assertSame(auditDetail, actualAuditRequest.getAuditDetail());
        assertEquals("Manager Name", actualAuditRequest.getManagerName());
        assertEquals("Project Name", actualAuditRequest.getProjectName());
        assertEquals(
                "AuditRequest(projectName=Project Name, managerName=Manager Name, auditDetail=AuditDetail(auditType=null,"
                        + " auditDate=null, auditQuestions=null))",
                actualToStringResult);
    }

    /**
     * Method under test: {@link AuditRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuditRequest(), null);
        assertNotEquals(new AuditRequest(), "Different type to AuditRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditRequest#equals(Object)}
     *   <li>{@link AuditRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuditRequest auditRequest = new AuditRequest();
        assertEquals(auditRequest, auditRequest);
        int expectedHashCodeResult = auditRequest.hashCode();
        assertEquals(expectedHashCodeResult, auditRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditRequest#equals(Object)}
     *   <li>{@link AuditRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuditRequest auditRequest = new AuditRequest();
        AuditRequest auditRequest1 = new AuditRequest();
        assertEquals(auditRequest, auditRequest1);
        int expectedHashCodeResult = auditRequest.hashCode();
        assertEquals(expectedHashCodeResult, auditRequest1.hashCode());
    }

    /**
     * Method under test: {@link AuditRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        AuditRequest auditRequest = new AuditRequest("Project Name", "Manager Name", new AuditDetail());
        assertNotEquals(auditRequest, new AuditRequest());
    }

    /**
     * Method under test: {@link AuditRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuditRequest auditRequest = new AuditRequest();
        assertNotEquals(auditRequest, new AuditRequest("Project Name", "Manager Name", new AuditDetail()));
    }

    /**
     * Method under test: {@link AuditRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        AuditRequest auditRequest = new AuditRequest();
        auditRequest.setManagerName("Manager Name");
        assertNotEquals(auditRequest, new AuditRequest());
    }

    /**
     * Method under test: {@link AuditRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        AuditRequest auditRequest = new AuditRequest();
        auditRequest.setAuditDetail(new AuditDetail());
        assertNotEquals(auditRequest, new AuditRequest());
    }
}

