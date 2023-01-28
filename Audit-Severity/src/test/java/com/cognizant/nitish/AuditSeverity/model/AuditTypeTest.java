package com.cognizant.nitish.AuditSeverity.model;

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
        assertFalse((new AuditType()).canEqual("Other"));
    }

    /**
     * Method under test: {@link AuditType#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        AuditType auditType = new AuditType();

        AuditType auditType1 = new AuditType();
        auditType1.setAuditType("Audit Type");
        assertTrue(auditType.canEqual(auditType1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link AuditType}
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
     * Method under test: {@link AuditType#equals(Object)}
     */
    @Test
    void testEquals() {
        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");
        assertNotEquals(auditType, null);
    }

    /**
     * Method under test: {@link AuditType#equals(Object)}
     */
    @Test
    void testEquals2() {
        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");
        assertNotEquals(auditType, "Different type to AuditType");
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
        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");
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
    void testEquals4() {
        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");

        AuditType auditType1 = new AuditType();
        auditType1.setAuditType("Audit Type");
        assertEquals(auditType, auditType1);
        int expectedHashCodeResult = auditType.hashCode();
        assertEquals(expectedHashCodeResult, auditType1.hashCode());
    }

    /**
     * Method under test: {@link AuditType#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuditType auditType = new AuditType();
        auditType.setAuditType(null);

        AuditType auditType1 = new AuditType();
        auditType1.setAuditType("Audit Type");
        assertNotEquals(auditType, auditType1);
    }

    /**
     * Method under test: {@link AuditType#equals(Object)}
     */
    @Test
    void testEquals6() {
        AuditType auditType = new AuditType();
        auditType.setAuditType("com.cognizant.nitish.AuditSeverity.model.AuditType");

        AuditType auditType1 = new AuditType();
        auditType1.setAuditType("Audit Type");
        assertNotEquals(auditType, auditType1);
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
    void testEquals7() {
        AuditType auditType = new AuditType();
        auditType.setAuditType(null);

        AuditType auditType1 = new AuditType();
        auditType1.setAuditType(null);
        assertEquals(auditType, auditType1);
        int expectedHashCodeResult = auditType.hashCode();
        assertEquals(expectedHashCodeResult, auditType1.hashCode());
    }
}

