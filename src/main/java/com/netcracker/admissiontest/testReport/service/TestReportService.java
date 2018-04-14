package com.netcracker.admissiontest.testReport.service;

import com.netcracker.admissiontest.testReport.entity.TestReport;
import com.netcracker.admissiontest.testReport.repository.TestReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestReportService {

    @Autowired
    private TestReportRepository testReportRepository;

    public List<TestReport> getAll(){

        List<TestReport> testReports = new ArrayList<>();

        for (TestReport testReport: testReportRepository.findAll()) {
            testReports.add(testReport);
        }

        return testReports;

    }


    public TestReport getTestReport(Long id){
        return testReportRepository.findById(id).get();
    }

    public void updateTestReport(Long id, TestReport testReport){
        testReportRepository.save(testReport);
    }

    public void createTestReport(TestReport testReport){
        testReportRepository.save(testReport);
    }

    public void deleteTestReport(Long id){
        testReportRepository.deleteById(id);
    }

}
