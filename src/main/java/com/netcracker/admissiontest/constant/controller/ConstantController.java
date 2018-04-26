package com.netcracker.admissiontest.constant.controller;

import com.netcracker.admissiontest.constant.entity.Constant;
import com.netcracker.admissiontest.constant.service.ConstantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/constant")
public class ConstantController {

    @Autowired
    private ConstantService constantService;

    @ApiOperation(value = "Get All constants", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Constant>> getAllConstantsListResponseEntity(){
        return new ResponseEntity<>(constantService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get constant by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public ResponseEntity<Constant> getAnswerById(@PathVariable("id") Long id){
        return new ResponseEntity<>(constantService.getConstant(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create constant", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createConstant(@RequestBody Constant constant) {
        constantService.createConstant(constant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update constant", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAnswer(@PathVariable("id") Long id, @RequestBody Constant constant) {
        constantService.updateConstante(id, constant);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete constant", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteConstant(@PathVariable("id") Long id) {
        constantService.deleteConstant(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }



}
