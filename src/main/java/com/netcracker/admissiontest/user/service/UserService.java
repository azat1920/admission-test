package com.netcracker.admissiontest.user.service;

import com.netcracker.admissiontest.role.entity.Role;
import com.netcracker.admissiontest.role.repository.RoleRepository;
import com.netcracker.admissiontest.user.entity.User;
import com.netcracker.admissiontest.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init(){
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role("admin"));
            roleRepository.save(new Role("user"));
        }
        List<Role> list = roleRepository.findByName("admin");
        System.out.println("out: " + list);
        createUser(new User("admin","email", list.get(0)));
    }

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