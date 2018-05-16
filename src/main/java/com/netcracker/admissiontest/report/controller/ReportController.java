package com.netcracker.admissiontest.report.controller;

import com.netcracker.admissiontest.report.entity.Report;
import com.netcracker.admissiontest.report.service.ReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @ApiOperation(value = "Get all reports", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Report>> getAllReports() {
        return new ResponseEntity<>(reportService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all reports by username", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/user/{username}/", method = RequestMethod.GET)
    public ResponseEntity<List<Report>> getAllReportsByUser(@PathVariable("username") String username) {
        return new ResponseEntity<>(reportService.getAllByUsername(username), HttpStatus.OK);
    }

    @ApiOperation(value = "Create reports", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createAnswer(@RequestBody List<Report> reports) {
        reportService.createReports(reports);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
