package com.netcracker.admissiontest.user.controller;

import com.netcracker.admissiontest.user.entity.User;
import com.netcracker.admissiontest.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all users", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get user by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserById(Long id){
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create user", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update user", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/user/", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody Long id, User user) {
        userService.updateUser(id, user);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Update user", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/user/", method = RequestMethod.DELETE)
    public ResponseEntity<?> updateUser(@RequestBody Long id) {
        userService.deleteUser(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}