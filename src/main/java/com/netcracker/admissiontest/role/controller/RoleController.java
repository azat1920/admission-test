package com.netcracker.admissiontest.role.controller;

import com.netcracker.admissiontest.role.entity.Role;
import com.netcracker.admissiontest.role.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "Get all roles", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get role by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/role/{id}/", method = RequestMethod.GET)
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id){
        return new ResponseEntity<>(roleService.getRole(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create role", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        roleService.createRole(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update role", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/{id}/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRole(@PathVariable("id") Long id, Role role) {
        roleService.updateRole(id, role);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete role", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value ="/role/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}