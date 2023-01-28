package com.cognizant.nitish.Audit_BenchMark.repository;

import com.cognizant.nitish.Audit_BenchMark.model.AuditBenchmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditBenchmarkRepo extends JpaRepository<AuditBenchmark
        , Integer> {


    List<AuditBenchmark> getAuditBenchmarkList();
}