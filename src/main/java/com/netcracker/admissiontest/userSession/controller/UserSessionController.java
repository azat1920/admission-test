package com.netcracker.admissiontest.userSession.controller;

import com.netcracker.admissiontest.userSession.entity.UserSession;
import com.netcracker.admissiontest.userSession.service.UserSessionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/usersession")
public class UserSessionController {


    @Autowired
    private UserSessionService userSessionService;

    @ApiOperation(value = "Get all userSession", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UserSession>> getAllUserSessions() {
        return new ResponseEntity<>(userSessionService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get userSession by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/usersession/{id}/", method = RequestMethod.GET)
    public ResponseEntity<UserSession> getUserSessionById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userSessionService.getUserSession(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create userSession", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createUserSession(@RequestBody UserSession userSession) {
        userSessionService.createUserSession(userSession);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update userSession", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserSession(@PathVariable("id") Long id, @RequestBody UserSession userSession) {
        userSessionService.updateUserSession(id, userSession);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete userSession", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/usersession/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserSession(@PathVariable("id") Long id) {
        userSessionService.deleteUserSession(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
