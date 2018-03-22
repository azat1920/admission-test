package com.netcracker.admissiontest.user.service;

import com.netcracker.admissiontest.user.entity.User;
import com.netcracker.admissiontest.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public User getUser(Long id) {

        return userRepository.getUser(id);
    }

    public void removeUser(Long id) {

       userRepository.removeUser(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
    public List<User> getAll(){
        return userRepository.getAll();
    }

}
