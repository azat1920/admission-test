package com.netcracker.admissiontest.user.controller;

import com.netcracker.admissiontest.user.entity.User;
import com.netcracker.admissiontest.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/user/{id}/", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create user", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update user", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestParam("id") Long id, User user) {
        userService.updateUser(id, user);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete user", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/user", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}