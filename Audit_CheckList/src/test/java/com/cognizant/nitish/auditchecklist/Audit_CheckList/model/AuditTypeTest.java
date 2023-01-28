package com.cognizant.nitish.auditchecklist.Audit_CheckList.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuditTypeTest {
    /**
     * Method under test: {@link AuditType#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new AuditType("Audit Type")).canEqual("Other"));
    }

    /**
     * Method under test: {@link AuditType#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        AuditType auditType = new AuditType("Audit Type");
        assertTrue(auditType.canEqual(new AuditType("Audit Type")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditType#AuditType()}
     *   <li>{@link AuditType#setAuditType(String)}
     *   <li>{@link AuditType#toString()}
     *   <li>{@link AuditType#getAuditType()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuditType actualAuditType = new AuditType();
        actualAuditType.setAuditType("Audit Type");
        String actualToStringResult = actualAuditType.toString();
        assertEquals("Audit Type", actualAuditType.getAuditType());
        assertEquals("AuditType(auditType=Audit Type)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditType#AuditType(String)}
     *   <li>{@link AuditType#setAuditType(String)}
     *   <li>{@link AuditType#toString()}
     *   <li>{@link AuditType#getAuditType()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        AuditType actualAuditType = new AuditType("Audit Type");
        actualAuditType.setAuditType("Audit Type");
        String actualToStringResult = actualAuditType.toString();
        assertEquals("Audit Type", actualAuditType.getAuditType());
        assertEquals("AuditType(auditType=Audit Type)", actualToStringResult);
    }

    /**
     * Method under test: {@link AuditType#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuditType("Audit Type"), null);
        assertNotEquals(new AuditType("Audit Type"), "Different type to AuditType");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditType#equals(Object)}
     *   <li>{@link AuditType#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuditType auditType = new AuditType("Audit Type");
        assertEquals(auditType, auditType);
        int expectedHashCodeResult = auditType.hashCode();
        assertEquals(expectedHashCodeResult, auditType.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditType#equals(Object)}
     *   <li>{@link AuditType#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuditType auditType = new AuditType("Audit Type");
        AuditType auditType1 = new AuditType("Audit Type");
        assertEquals(auditType, auditType1);
        int expectedHashCodeResult = auditType.hashCode();
        assertEquals(expectedHashCodeResult, auditType1.hashCode());
    }

    /**
     * Method under test: {@link AuditType#equals(Object)}
     */
    @Test
    void testEquals4() {
        AuditType auditType = new AuditType(null);
        assertNotEquals(auditType, new AuditType("Audit Type"));
    }

    /**
     * Method under test: {@link AuditType#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuditType auditType = new AuditType("com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuditType");
        assertNotEquals(auditType, new AuditType("Audit Type"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditType#equals(Object)}
     *   <li>{@link AuditType#hashCode()}
     * </ul>
     */
    @Test
    void testEquals6() {
        AuditType auditType = new AuditType(null);
        AuditType auditType1 = new AuditType(null);
        assertEquals(auditType, auditType1);
        int expectedHashCodeResult = auditType.hashCode();
        assertEquals(expectedHashCodeResult, auditType1.hashCode());
    }
}

