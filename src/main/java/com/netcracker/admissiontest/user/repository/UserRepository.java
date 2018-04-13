package com.netcracker.admissiontest.user.repository;

import com.netcracker.admissiontest.user.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository <User, Long>{


}
