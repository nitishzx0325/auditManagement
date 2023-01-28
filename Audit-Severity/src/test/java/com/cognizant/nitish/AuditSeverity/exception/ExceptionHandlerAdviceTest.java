package com.cognizant.nitish.AuditSeverity.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ExceptionHandlerAdviceTest {
    /**
     * Method under test: {@link ExceptionHandlerAdvice#exception(Exception)}
     */
    @Test
    void testException() {
        ExceptionHandlerAdvice exceptionHandlerAdvice = new ExceptionHandlerAdvice();
        ResponseEntity<?> actualExceptionResult = exceptionHandlerAdvice.exception(new Exception("An error occurred"));
        assertTrue(actualExceptionResult.hasBody());
        assertTrue(actualExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualExceptionResult.getStatusCode());
    }

    /**
     * Method under test: {@link ExceptionHandlerAdvice#exception(Exception)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testException2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Exception.getMessage()" because "e" is null
        //       at com.cognizant.nitish.AuditSeverity.exception.ExceptionHandlerAdvice.exception(ExceptionHandlerAdvice.java:22)
        //   In order to prevent exception(Exception)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   exception(Exception).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ExceptionHandlerAdvice()).exception(null);
    }
}

