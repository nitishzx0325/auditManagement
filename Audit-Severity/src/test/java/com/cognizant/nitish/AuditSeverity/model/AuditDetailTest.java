package com.cognizant.nitish.AuditSeverity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuditDetail.class})
@ExtendWith(SpringExtension.class)
class AuditDetailTest {
    @Autowired
    private AuditDetail auditDetail;

    /**
     * Method under test: {@link AuditDetail#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(auditDetail.canEqual("Other"));
        assertTrue(auditDetail.canEqual(auditDetail));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditDetail#AuditDetail()}
     *   <li>{@link AuditDetail#setAuditDate(Date)}
     *   <li>{@link AuditDetail#setAuditQuestions(List)}
     *   <li>{@link AuditDetail#setAuditType(String)}
     *   <li>{@link AuditDetail#toString()}
     *   <li>{@link AuditDetail#getAuditDate()}
     *   <li>{@link AuditDetail#getAuditQuestions()}
     *   <li>{@link AuditDetail#getAuditType()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuditDetail actualAuditDetail = new AuditDetail();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualAuditDetail.setAuditDate(fromResult);
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<>();
        actualAuditDetail.setAuditQuestions(auditQuestionList);
        actualAuditDetail.setAuditType("Audit Type");
        actualAuditDetail.toString();
        assertSame(fromResult, actualAuditDetail.getAuditDate());
        assertSame(auditQuestionList, actualAuditDetail.getAuditQuestions());
        assertEquals("Audit Type", actualAuditDetail.getAuditType());
    }

    /**
     * Method under test: {@link AuditDetail#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new AuditDetail(), null);
        assertNotEquals(new AuditDetail(), "Different type to AuditDetail");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditDetail#equals(Object)}
     *   <li>{@link AuditDetail#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        AuditDetail auditDetail = new AuditDetail();
        assertEquals(auditDetail, auditDetail);
        int expectedHashCodeResult = auditDetail.hashCode();
        assertEquals(expectedHashCodeResult, auditDetail.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditDetail#equals(Object)}
     *   <li>{@link AuditDetail#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        AuditDetail auditDetail = new AuditDetail();
        AuditDetail auditDetail1 = new AuditDetail();
        assertEquals(auditDetail, auditDetail1);
        int expectedHashCodeResult = auditDetail.hashCode();
        assertEquals(expectedHashCodeResult, auditDetail1.hashCode());
    }

    /**
     * Method under test: {@link AuditDetail#equals(Object)}
     */
    @Test
    void testEquals4() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date auditDate = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        AuditDetail auditDetail = new AuditDetail("Audit Type", auditDate, new ArrayList<>());
        assertNotEquals(auditDetail, new AuditDetail());
    }

    /**
     * Method under test: {@link AuditDetail#equals(Object)}
     */
    @Test
    void testEquals5() {
        AuditDetail auditDetail = new AuditDetail();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date auditDate = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        assertNotEquals(auditDetail, new AuditDetail("Audit Type", auditDate, new ArrayList<>()));
    }

    /**
     * Method under test: {@link AuditDetail#equals(Object)}
     */
    @Test
    void testEquals6() {
        AuditDetail auditDetail = new AuditDetail();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditDetail.setAuditDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertNotEquals(auditDetail, new AuditDetail());
    }

    /**
     * Method under test: {@link AuditDetail#equals(Object)}
     */
    @Test
    void testEquals7() {
        AuditDetail auditDetail = new AuditDetail();
        auditDetail.setAuditQuestions(new ArrayList<>());
        assertNotEquals(auditDetail, new AuditDetail());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditDetail#equals(Object)}
     *   <li>{@link AuditDetail#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date auditDate = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        AuditDetail auditDetail = new AuditDetail("Audit Type", auditDate, new ArrayList<>());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date auditDate1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        AuditDetail auditDetail1 = new AuditDetail("Audit Type", auditDate1, new ArrayList<>());

        assertEquals(auditDetail, auditDetail1);
        int expectedHashCodeResult = auditDetail.hashCode();
        assertEquals(expectedHashCodeResult, auditDetail1.hashCode());
    }

    /**
     * Method under test: {@link AuditDetail#equals(Object)}
     */
    @Test
    void testEquals9() {
        AuditDetail auditDetail = new AuditDetail();

        AuditDetail auditDetail1 = new AuditDetail();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditDetail1.setAuditDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        assertNotEquals(auditDetail, auditDetail1);
    }

    /**
     * Method under test: {@link AuditDetail#equals(Object)}
     */
    @Test
    void testEquals10() {
        AuditDetail auditDetail = new AuditDetail();

        AuditDetail auditDetail1 = new AuditDetail();
        auditDetail1.setAuditQuestions(new ArrayList<>());
        assertNotEquals(auditDetail, auditDetail1);
    }
}

