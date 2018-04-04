package com.netcracker.admissiontest.userSession.service;

import com.netcracker.admissiontest.userSession.entity.UserSession;
import com.netcracker.admissiontest.userSession.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/usersession")
public class UserSessionService {

    @Autowired
    private UserSessionRepository userSessionRepository;


    public void createUserSession(UserSession userSession) {
        userSessionRepository.save(userSession);
    }

    public List<UserSession> getAll(){
        List <UserSession> list = new ArrayList<>();
        for(UserSession userSession : userSessionRepository.findAll()) {
            list.add(userSession);
        }
        return list;
    }

    public UserSession getUserSession(long id){
        return userSessionRepository.findById(id).get();
    }

    public void updateUserSession(Long id, UserSession userSession){
        userSessionRepository.save(userSession);
    }

    public void deleteUserSession(Long id){
        userSessionRepository.deleteById(id);
    }
}
