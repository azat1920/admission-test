package com.netcracker.admissiontest.UserSessionQuestionAnswer.service;

import com.netcracker.admissiontest.UserSessionQuestionAnswer.entity.UserSessionQuestionAnswer;
import com.netcracker.admissiontest.UserSessionQuestionAnswer.repository.UserSessionQuestionAnswerRepository;
import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.answer.repository.AnswerRepository;
import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.repository.QuestionRepository;
import com.netcracker.admissiontest.role.entity.Role;
import com.netcracker.admissiontest.role.repository.RoleRepository;
import com.netcracker.admissiontest.user.entity.User;
import com.netcracker.admissiontest.user.repository.UserRepository;
import com.netcracker.admissiontest.user.service.UserService;
import com.netcracker.admissiontest.userSession.entity.UserSession;
import com.netcracker.admissiontest.userSession.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserSessionQuestionAnswerService {

    @Autowired
    private UserSessionQuestionAnswerRepository userSessionQuestionAnswerRepository;


    public List<UserSessionQuestionAnswer> getAll(){

        List<UserSessionQuestionAnswer> userSessionQuestionAnswers = new ArrayList<>();

        for (UserSessionQuestionAnswer userSessionQuestionAnswer : userSessionQuestionAnswerRepository.findAll()) {
            userSessionQuestionAnswers.add(userSessionQuestionAnswer);
        }

        return userSessionQuestionAnswers;

    }


    public UserSessionQuestionAnswer getUserSessionQuestionAnswer(Long id){
        return userSessionQuestionAnswerRepository.findById(id).get();
    }

    public void updateUserSessionQuestionAnswer(Long id, UserSessionQuestionAnswer userSessionQuestionAnswer){
        this.userSessionQuestionAnswerRepository.save(userSessionQuestionAnswer);
    }

    public void createUserSessionQuestionAnswer(UserSessionQuestionAnswer userSessionQuestionAnswer){
        this.userSessionQuestionAnswerRepository.save(userSessionQuestionAnswer);
    }

    public void deleteUserSessionQuestionAnswer(Long id){
        userSessionQuestionAnswerRepository.deleteById(id);
    }

}
