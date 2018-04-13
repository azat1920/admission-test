package com.netcracker.admissiontest.questionCategory.controller;

import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.service.QuestionService;
import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import com.netcracker.admissiontest.questionCategory.service.QuestionCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/question_category")
public class QuestionCategoryController {

    @Autowired
    private QuestionCategoryService questionCategoryService;

    @ApiOperation(value = "Get all question categories", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<QuestionCategory>> getAllQuestionCategories() {
        return new ResponseEntity<>(questionCategoryService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get question categories by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/question_categories/{id}/", method = RequestMethod.GET)
    public ResponseEntity<QuestionCategory> getQuestionCategoryById(@PathVariable("id") Long id){
        return new ResponseEntity<>(questionCategoryService.getQuestionCategory(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create question category", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createQuestionCategory(@RequestBody QuestionCategory questionCategory) {
        questionCategoryService.createQuestionCategory(questionCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update question category", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/question_category/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuestionCategory(@PathVariable("id") Long id, @RequestBody QuestionCategory questionCategory) {
        questionCategoryService.updateQuestionCategory(id, questionCategory);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete question category", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/question_category/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuestionCategory(@PathVariable("id") Long id) {
        questionCategoryService.deleteQuestionCategory(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
