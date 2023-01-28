package com.cognizant.nitish.Audit_BenchMark.service;

import com.cognizant.nitish.Audit_BenchMark.model.AuditBenchmark;
import com.cognizant.nitish.Audit_BenchMark.repository.AuditBenchmarkRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AuditBenchmarkService {
    List<AuditBenchmark> getAuditBenchmarkList();
}
