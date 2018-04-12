package com.netcracker.admissiontest.user.service;

import com.netcracker.admissiontest.role.entity.Role;
import com.netcracker.admissiontest.role.repository.RoleRepository;
import com.netcracker.admissiontest.user.entity.User;
import com.netcracker.admissiontest.user.repository.UserRepository;
import com.netcracker.admissiontest.userSession.entity.UserSession;
import com.netcracker.admissiontest.userSession.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    UserSessionRepository userSessionRepository;

    @PostConstruct
    public void init(){
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role("admin"));
            roleRepository.save(new Role("user"));
        }
        List<Role> listAdmin = roleRepository.findByName("admin");
        System.out.println("out: " + listAdmin);
        createUser(new User("admin","email", listAdmin.get(0)));

        List<Role> listUser = roleRepository.findByName("user");
        createUser(new User("user_1", "email_1", listUser.get(0)));

        User u1 = userRepository.findById(new Long(1)).get();
        User u2 = userRepository.findById(new Long(2)).get();

        System.out.println("User:" + u1.toString());
        System.out.println("User:" + u2.toString());


        UserSession us1 = new UserSession(u1, new Date(),new Date());
        UserSession us2 = new UserSession(u2, new Date(),new Date());

        System.out.println(us1.toString());
        System.out.println(us2.toString());


        userSessionRepository.save(us1);
        userSessionRepository.save(us2);

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