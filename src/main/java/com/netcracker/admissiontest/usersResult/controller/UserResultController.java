package com.netcracker.admissiontest.usersResult.controller;


import com.netcracker.admissiontest.usersResult.entity.UserResult;
import com.netcracker.admissiontest.usersResult.repository.UserResultRepository;
import com.netcracker.admissiontest.usersResult.service.UserResultService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/results/")
public class UserResultController {

    @Autowired
    private UserResultService userResultService;

    @ApiOperation(value = "Get all results", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UserResult>> getAllReports() {
        return new ResponseEntity<>(userResultService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Create result", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createAnswer(@RequestBody UserResult result) {
        userResultService.createUserResult(result);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get result by username", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/result/{username}/", method = RequestMethod.GET)
    public ResponseEntity<UserResult> getAllReportsByUser(@PathVariable("username") String username) {
        return new ResponseEntity<>(userResultService.getUserResult(username), HttpStatus.OK);
    }


}
