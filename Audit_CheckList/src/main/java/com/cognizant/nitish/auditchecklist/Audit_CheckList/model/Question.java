package com.cognizant.nitish.auditchecklist.Audit_CheckList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class Question {
    @Id
    @GeneratedValue
    @Column
    private int questionId;
    @Column
    private String question;
    @Column
    private String auditType;
    @Column
    private String response;

}
