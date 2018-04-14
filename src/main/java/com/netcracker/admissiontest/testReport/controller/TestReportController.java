package com.netcracker.admissiontest.testReport.controller;

import com.netcracker.admissiontest.testReport.entity.TestReport;
import com.netcracker.admissiontest.testReport.service.TestReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/testreport")
public class TestReportController {

    @Autowired
    private TestReportService testReportService;

    @ApiOperation(value = "Get all test reports", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TestReport>> getAllTestReport() {
        return new ResponseEntity<>(testReportService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get test report by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/testreport/{id}/", method = RequestMethod.GET)
    public ResponseEntity<TestReport> getTestReportById(@PathVariable("id") Long id){
        return new ResponseEntity<>(testReportService.getTestReport(id), HttpStatus.OK);
    }


    @ApiOperation(value = "Create test report", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createTestReport(@RequestBody TestReport testReport) {
        testReportService.createTestReport((testReport));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update test report", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/testreport/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTestReport(@PathVariable("id") Long id, @RequestBody TestReport testReport) {
        testReportService.updateTestReport(id, testReport);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete test report", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/testreport/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTestReport(@PathVariable("id") Long id) {
        testReportService.deleteTestReport(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }



}
