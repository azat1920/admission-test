package com.netcracker.admissiontest.UserSessionQuestionAnswer.service;

import com.netcracker.admissiontest.UserSessionQuestionAnswer.entity.UserSessionQuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSessionQuestionAnswerService {

    @Autowired
    private com.netcracker.admissiontest.UserSessionQuestionAnswer.repository.UserSessionQuestionAnswer userSessionQuestionAnswer;

    public List<UserSessionQuestionAnswer> getAll(){

        List<UserSessionQuestionAnswer> userSessionQuestionAnswers = new ArrayList<>();

        for (UserSessionQuestionAnswer userSessionQuestionAnswer : this.userSessionQuestionAnswer.findAll()) {
            userSessionQuestionAnswers.add(userSessionQuestionAnswer);
        }

        return userSessionQuestionAnswers;

    }


    public UserSessionQuestionAnswer getTestReport(Long id){
        return userSessionQuestionAnswer.findById(id).get();
    }

    public void updateTestReport(Long id, UserSessionQuestionAnswer userSessionQuestionAnswer){
        this.userSessionQuestionAnswer.save(userSessionQuestionAnswer);
    }

    public void createTestReport(UserSessionQuestionAnswer userSessionQuestionAnswer){
        this.userSessionQuestionAnswer.save(userSessionQuestionAnswer);
    }

    public void deleteTestReport(Long id){
        userSessionQuestionAnswer.deleteById(id);
    }

}
