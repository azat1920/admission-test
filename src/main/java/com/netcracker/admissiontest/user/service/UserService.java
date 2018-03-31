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
        userRepository.save(user);
    }

    public List<User> getAll(){
        List <User> list = new ArrayList<>();
        for(User user : userRepository.findAll()) {
            list.add(user);
        }
        return list;
    }

    public User getUser(long id){
        return userRepository.findById(id).get();
    }

    public void updateUser(Long id, User user){
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}