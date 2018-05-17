package com.netcracker.admissiontest.usersResult.repository;

import com.netcracker.admissiontest.user.entity.User;
import com.netcracker.admissiontest.usersResult.entity.UserResult;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserResultRepository extends CrudRepository<UserResult, Long> {
    List<UserResult> findAllByUser(User user);
}
