package com.netcracker.admissiontest.testReport.repository;


import com.netcracker.admissiontest.testReport.entity.TestReport;
import org.springframework.data.repository.CrudRepository;

import javax.sql.rowset.CachedRowSet;

public interface TestReportRepository extends CrudRepository<TestReport, Long> {
}
