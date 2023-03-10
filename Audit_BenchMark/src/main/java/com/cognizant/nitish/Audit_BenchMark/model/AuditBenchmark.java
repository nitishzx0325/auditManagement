package com.cognizant.nitish.Audit_BenchMark.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="audit_benchmark")
public class AuditBenchmark {
    @Id
    @Column(name="benchmark_id")
    @GeneratedValue
    private int benchmarkId;

    @Column(name="audit_type")
    private String auditType;

    @Column(name="benchmark_no_answers")
    private int benchmarkNoAnswers;
}
