package com.netcracker.admissiontest.UserSessionQuestionAnswer.controller;

import com.netcracker.admissiontest.UserSessionQuestionAnswer.entity.UserSessionQuestionAnswer;
import com.netcracker.admissiontest.UserSessionQuestionAnswer.service.UserSessionQuestionAnswerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/usersessionquestionanswer")
public class UserSessionQuestionAnswerController {

    @Autowired
    private UserSessionQuestionAnswerService userSessionQuestionAnswerService;

    @ApiOperation(value = "Get all test reports", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UserSessionQuestionAnswer>> getAllUserSessionQuestionAnswer() {
        return new ResponseEntity<>(userSessionQuestionAnswerService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get test report by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/usersessionquestionanswer/{id}/", method = RequestMethod.GET)
    public ResponseEntity<UserSessionQuestionAnswer> getUserSessionQuestionAnswerById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userSessionQuestionAnswerService.getUserSessionQuestionAnswer(id), HttpStatus.OK);
    }


    @ApiOperation(value = "Create test report", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createUserSessionQuestionAnswer(@RequestBody UserSessionQuestionAnswer userSessionQuestionAnswer) {
        this.userSessionQuestionAnswerService.createUserSessionQuestionAnswer((userSessionQuestionAnswer));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update test report", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/usersessionquestionanswer/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserSessionQuestionAnswer(@PathVariable("id") Long id, @RequestBody UserSessionQuestionAnswer userSessionQuestionAnswer) {
        this.userSessionQuestionAnswerService.updateUserSessionQuestionAnswer(id, userSessionQuestionAnswer);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete test report", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/usersessionquestionanswer/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserSessionQuestionAnswer(@PathVariable("id") Long id) {
        userSessionQuestionAnswerService.deleteUserSessionQuestionAnswer(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }



}
