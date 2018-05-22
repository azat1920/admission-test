package com.netcracker.admissiontest.question.controller;

import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.service.QuestionGeneratorService;
import com.netcracker.admissiontest.question.service.QuestionService;
import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import com.netcracker.admissiontest.questionCategory.service.QuestionCategoryService;
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
    @Autowired
    private QuestionCategoryService questionCategoryService;

    @Autowired
    QuestionGeneratorService questionGeneratorService;

    @ApiOperation(value = "Get all questions", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get question by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/question/{id}/", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") Long id){
        return new ResponseEntity<>(questionService.getQuestion(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create question", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return new ResponseEntity<Question>(questionService.createQuestion(question), HttpStatus.CREATED);
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

    @ApiOperation(value = "Get random questions", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/generated/", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getRandomQuestions() {

        return  new ResponseEntity<>(questionGeneratorService.getRandomQuestions(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get questions by category Id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getQuestionsByCategoryId(@PathVariable("id") Long id) {
        QuestionCategory questionCategory = questionCategoryService.getQuestionCategory(id);
        return  new ResponseEntity<List<Question>>(questionService.getQuestionsByCategoryId(questionCategory), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete questions by category id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/category/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestionByCategoryId(@PathVariable("id") Long id) {
        QuestionCategory questionCategory = questionCategoryService.getQuestionCategory(id);
        questionService.deleteQuestionByCategory(questionCategory);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
