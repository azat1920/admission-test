package com.netcracker.admissiontest.user.controller;

import com.netcracker.admissiontest.user.entity.User;
import com.netcracker.admissiontest.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @ApiOperation(value = "Get user by name and password", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserByNameAndPassword(
            @ApiParam(value = "User name")
            @RequestParam(name = "name") String name,
            @ApiParam(value = "User password")
            @RequestParam(name = "password") String password) {
        List<User> users = userService.getUserByNameAndPassowerd(name, password);
        if (users.size() > 0) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
        }
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
    @RequestMapping(value ="/user/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete user", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/user/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
