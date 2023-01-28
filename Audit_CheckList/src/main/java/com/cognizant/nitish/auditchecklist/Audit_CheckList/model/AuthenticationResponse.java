package com.cognizant.nitish.auditchecklist.Audit_CheckList.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String name;
    private String projectName;
    private boolean isValid;


}
