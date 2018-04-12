package com.netcracker.admissiontest.userSession.service;

import com.netcracker.admissiontest.user.repository.UserRepository;
import com.netcracker.admissiontest.userSession.entity.UserSession;
import com.netcracker.admissiontest.userSession.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*@RestController
@RequestMapping("/usersession")*/
@Service
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
