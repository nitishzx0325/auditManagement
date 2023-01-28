package com.cognizant.nitish.AuditSeverity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuditBenchmark.class})
@ExtendWith(SpringExtension.class)
class AuditBenchmarkTest {
    @Autowired
    private AuditBenchmark auditBenchmark;

    /**
     * Method under test: {@link AuditBenchmark#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(auditBenchmark.canEqual("Other"));
        assertTrue(auditBenchmark.canEqual(auditBenchmark));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditBenchmark#AuditBenchmark(int, String, int)}
     *   <li>{@link AuditBenchmark#setAuditType(String)}
     *   <li>{@link AuditBenchmark#setBenchmarkId(int)}
     *   <li>{@link AuditBenchmark#setBenchmarkNoAnswers(int)}
     *   <li>{@link AuditBenchmark#toString()}
     *   <li>{@link AuditBenchmark#getAuditType()}
     *   <li>{@link AuditBenchmark#getBenchmarkId()}
     *   <li>{@link AuditBenchmark#getBenchmarkNoAnswers()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuditBenchmark actualAuditBenchmark = new AuditBenchmark(123, "Audit Type", 1);
        actualAuditBenchmark.setAuditType("Audit Type");
        actualAuditBenchmark.setBenchmarkId(123);
        actualAuditBenchmark.setBenchmarkNoAnswers(1);
        String actualToStringResult = actualAuditBenchmark.toString();
        assertEquals("Audit Type", actualAuditBenchmark.getAuditType());
        assertEquals(123, actualAuditBenchmark.getBenchmarkId());
        assertEquals(1, actualAuditBenchmark.getBenchmarkNoAnswers());
        assertEquals("AuditBenchmark(benchmarkId=123, auditType=Audit Type, benchmarkNoAnswers=1)", actualToStringResult);
    }

    /**
     * Method under test: {@link AuditBenchmark#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuditBenchmark(123, "Audit Type", 1), null);
        assertNotEquals(new AuditBenchmark(123, "Audit Type", 1), "Different type to AuditBenchmark");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditBenchmark#equals(Object)}
     *   <li>{@link AuditBenchmark#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuditBenchmark auditBenchmark = new AuditBenchmark(123, "Audit Type", 1);
        assertEquals(auditBenchmark, auditBenchmark);
        int expectedHashCodeResult = auditBenchmark.hashCode();
        assertEquals(expectedHashCodeResult, auditBenchmark.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditBenchmark#equals(Object)}
     *   <li>{@link AuditBenchmark#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuditBenchmark auditBenchmark = new AuditBenchmark(123, "Audit Type", 1);
        AuditBenchmark auditBenchmark1 = new AuditBenchmark(123, "Audit Type", 1);

        assertEquals(auditBenchmark, auditBenchmark1);
        int expectedHashCodeResult = auditBenchmark.hashCode();
        assertEquals(expectedHashCodeResult, auditBenchmark1.hashCode());
    }

    /**
     * Method under test: {@link AuditBenchmark#equals(Object)}
     */
    @Test
    void testEquals4() {
        AuditBenchmark auditBenchmark = new AuditBenchmark(1, "Audit Type", 1);
        assertNotEquals(auditBenchmark, new AuditBenchmark(123, "Audit Type", 1));
    }

    /**
     * Method under test: {@link AuditBenchmark#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuditBenchmark auditBenchmark = new AuditBenchmark(123, null, 1);
        assertNotEquals(auditBenchmark, new AuditBenchmark(123, "Audit Type", 1));
    }

    /**
     * Method under test: {@link AuditBenchmark#equals(Object)}
     */
    @Test
    void testEquals6() {
        AuditBenchmark auditBenchmark = new AuditBenchmark(123, "com.cognizant.nitish.AuditSeverity.model.AuditBenchmark",
                1);
        assertNotEquals(auditBenchmark, new AuditBenchmark(123, "Audit Type", 1));
    }

    /**
     * Method under test: {@link AuditBenchmark#equals(Object)}
     */
    @Test
    void testEquals7() {
        AuditBenchmark auditBenchmark = new AuditBenchmark(123, "Audit Type", 3);
        assertNotEquals(auditBenchmark, new AuditBenchmark(123, "Audit Type", 1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditBenchmark#equals(Object)}
     *   <li>{@link AuditBenchmark#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        AuditBenchmark auditBenchmark = new AuditBenchmark(123, null, 1);
        AuditBenchmark auditBenchmark1 = new AuditBenchmark(123, null, 1);

        assertEquals(auditBenchmark, auditBenchmark1);
        int expectedHashCodeResult = auditBenchmark.hashCode();
        assertEquals(expectedHashCodeResult, auditBenchmark1.hashCode());
    }
}

