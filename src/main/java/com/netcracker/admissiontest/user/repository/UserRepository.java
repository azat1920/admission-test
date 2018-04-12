package com.netcracker.admissiontest.user.repository;

import com.netcracker.admissiontest.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository <User, Long>{


}
