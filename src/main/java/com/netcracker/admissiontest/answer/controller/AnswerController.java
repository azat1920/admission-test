package com.netcracker.admissiontest.answer.controller;


import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.answer.service.AnswerGeneratorService;
import com.netcracker.admissiontest.answer.service.AnswerService;
import com.netcracker.admissiontest.question.entity.Question;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerGeneratorService answerGeneratorService;


    Logger logger = LoggerFactory.getLogger(AnswerController.class);

    @ApiOperation(value = "Get all answers", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getAllAnswers() {
        logger.info("Start getting all answers " + new Date().toString());
        return new ResponseEntity<>(answerService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all correct answers", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/correct/", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getAllCorrectAnswers() {
        return new ResponseEntity<>(answerService.getAllCorrectAnswers(), HttpStatus.OK);
    }


    @ApiOperation(value = "Get answer by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/answer/{id}/", method = RequestMethod.GET)
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Long id){
        return new ResponseEntity<>(answerService.getAnswer(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Get answers by question id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/question/{id}/", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getAnswerByQuestionId(@PathVariable("id") Long id){
        return new ResponseEntity<>(answerService.getAnswerByQuestionId(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Get generated questions and answers of test", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/test/", method = RequestMethod.GET)
    public ResponseEntity<Map<Question, Set<Answer>>> getGeneratedTest() {
        logger.info("Start a generating test " + new Date().toString());
        ResponseEntity<Map<Question, Set<Answer>>> temp = new ResponseEntity<>(answerGeneratorService.getGeneratedTest(), HttpStatus.OK);
        logger.info("Finish a generating test  " + new Date().toString());
        return temp;
    }

    @ApiOperation(value = "Get generated answers of test", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/test/answers/", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> getGeneratedAnswersOfTest() {
        logger.info("Start a generating test " + new Date().toString());
        ResponseEntity<List<Answer>> answers = new ResponseEntity<>(answerGeneratorService.getGeneratedAnswersOfTest(),
                HttpStatus.OK);
        logger.info("Finish a generating test  " + new Date().toString());
        return answers;
    }


    @ApiOperation(value = "Create answer", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createAnswer(@RequestBody Answer answer) {
        answerService.createAnswer(answer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update answer", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/answer/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAnswer(@PathVariable("id") Long id, @RequestBody Answer answer) {
        answerService.updateAnswer(id, answer);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete answer", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/answer/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAnswer(@PathVariable("id") Long id) {
        answerService.deleteAnswer(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Check correct answers", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/check/", method = RequestMethod.POST)
    public ResponseEntity<Long> checkCorrectAnswers(@RequestBody List<Answer> answers) {
        return new ResponseEntity<>(answerService.checkCorrectAnswers(answers), HttpStatus.CREATED);
    }


}
