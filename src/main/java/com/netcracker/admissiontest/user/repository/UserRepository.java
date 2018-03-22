package com.netcracker.admissiontest.user.repository;

import com.netcracker.admissiontest.user.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRepository {

    private Map<Long, User> users;

    @PostConstruct
    public void init() {
        users = new HashMap<>();
        createUser(new User(1L, "user1", ""));
        createUser(new User(2L, "user2", ""));
        createUser(new User(3L, "user3", ""));
    }

    public void createUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(Long id) {

        return (User)users.get(id);
    }

    public void removeUser(Long id) {

        users.remove(id);
    }

    public void updateUser(User user) {
        users.put(user.getId(), user);
    }

    public List<User> getAll(){
        return new ArrayList<>(users.values());


    }



}
