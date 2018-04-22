package com.netcracker.admissiontest.user.entity;

import com.netcracker.admissiontest.role.entity.Role;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")//, nullable = false)
    private Role role;

    public User() {}

    public User(String name, String password, String email,  Role role) {

        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;


    }


    @Override
    public String toString() {
        return id + ":" + name;
    }



    public Long getId () {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    public UserSession getUserSession() {
//        return userSession;
//    }
//
//    public void setUserSession(UserSession userSession) {
//        this.userSession = userSession;
//    }


}
