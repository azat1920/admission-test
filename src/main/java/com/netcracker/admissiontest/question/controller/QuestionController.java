package com.netcracker.admissiontest.question.controller;

import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "Get all questions", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getAllQuestons() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get question by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/question/{id}/", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") Long id){
        return new ResponseEntity<>(questionService.getQuestion(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create question", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createQuestion(@RequestBody Question question) {
        questionService.createQuestion(question);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update question", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/question/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuestion(@PathVariable("id") Long id, @RequestBody Question question) {
        questionService.updateQuestion(id, question);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete question", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/question/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
