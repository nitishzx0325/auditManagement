package com.cognizant.nitish.AuditSeverity.model;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class AuditResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuditResponse#AuditResponse()}
     *   <li>{@link AuditResponse#setCreationDateTime(Date)}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuditResponse actualAuditResponse = new AuditResponse();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualAuditResponse.setCreationDateTime(fromResult);
        assertSame(fromResult, actualAuditResponse.getCreationDateTime());
    }
}

