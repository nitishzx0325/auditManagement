package com.cognizant.nitish.auditchecklist.Audit_CheckList.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.nitish.auditchecklist.Audit_CheckList.feign.AuthorizationFeign;
import com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuthenticationResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthorizationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AuthorizationServiceImplTest {
    @MockBean
    private AuthorizationFeign authorizationFeign;

    @Autowired
    private AuthorizationServiceImpl authorizationServiceImpl;

    /**
     * Method under test: {@link AuthorizationServiceImpl#validateJwt(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateJwt() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cognizant.nitish.auditchecklist.Audit_CheckList.model.AuthenticationResponse.isValid()" because "authenticationResponse" is null
        //       at com.cognizant.nitish.auditchecklist.Audit_CheckList.service.AuthorizationServiceImpl.validateJwt(AuthorizationServiceImpl.java:18)
        //   In order to prevent validateJwt(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   validateJwt(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(authorizationFeign.validate((String) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        authorizationServiceImpl.validateJwt("Jwt");
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#validateJwt(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateJwt2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.http.ResponseEntity.getBody()" because the return value of "com.cognizant.nitish.auditchecklist.Audit_CheckList.feign.AuthorizationFeign.validate(String)" is null
        //       at com.cognizant.nitish.auditchecklist.Audit_CheckList.service.AuthorizationServiceImpl.validateJwt(AuthorizationServiceImpl.java:17)
        //   In order to prevent validateJwt(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   validateJwt(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(authorizationFeign.validate((String) any())).thenReturn(null);
        authorizationServiceImpl.validateJwt("Jwt");
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#validateJwt(String)}
     */
    @Test
    void testValidateJwt3() {
        when(authorizationFeign.validate((String) any())).thenReturn(
                new ResponseEntity<>(new AuthenticationResponse("Name", "Project Name", true), HttpStatus.CONTINUE));
        assertTrue(authorizationServiceImpl.validateJwt("Jwt"));
        verify(authorizationFeign).validate((String) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#validateJwt(String)}
     */
    @Test
    void testValidateJwt4() {
        when(authorizationFeign.validate((String) any())).thenReturn(
                new ResponseEntity<>(new AuthenticationResponse("Name", "Project Name", false), HttpStatus.CONTINUE));
        assertFalse(authorizationServiceImpl.validateJwt("Jwt"));
        verify(authorizationFeign).validate((String) any());
    }
}

