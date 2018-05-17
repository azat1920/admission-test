package com.netcracker.admissiontest.usersResult.service;

import com.netcracker.admissiontest.usersResult.entity.UserResult;
import com.netcracker.admissiontest.usersResult.repository.UserResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserResultService {


    @Autowired
    private UserResultRepository userResultRepository;

    public List<UserResult> getAll(){
        List<UserResult> userResults = new ArrayList<>();

        for (UserResult userResult: userResultRepository.findAll()) {
            userResults.add(userResult);
        }

        return userResults;
    }

    public void createUserResult(UserResult userResult){
        userResultRepository.save(userResult);
    }

}
