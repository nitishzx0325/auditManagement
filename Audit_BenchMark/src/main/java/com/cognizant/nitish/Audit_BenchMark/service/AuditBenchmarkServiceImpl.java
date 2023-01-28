package com.cognizant.nitish.Audit_BenchMark.service;

import com.cognizant.nitish.Audit_BenchMark.model.AuditBenchmark;
import com.cognizant.nitish.Audit_BenchMark.repository.AuditBenchmarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuditBenchmarkServiceImpl implements AuditBenchmarkService{

    @Autowired
    private AuditBenchmarkRepo auditBenchmarkRepo;

    @Override
    public List<AuditBenchmark> getAuditBenchmarkList(){
        return auditBenchmarkRepo.findAll();
    }

}
