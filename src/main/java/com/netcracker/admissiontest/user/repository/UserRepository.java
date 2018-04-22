package com.netcracker.admissiontest.user.repository;

import com.netcracker.admissiontest.role.entity.Role;
import com.netcracker.admissiontest.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository <User, Long>{

    List<User> findByNameAndPassword(String name, String password);


}
