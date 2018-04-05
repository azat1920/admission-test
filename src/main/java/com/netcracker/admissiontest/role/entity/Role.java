package com.netcracker.admissiontest.role.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    @NotNull
    private String name;


    //@JsonManagedReference
    //@JsonBackReference
/*
    @OneToMany(cascade = CascadeType.ALL,   mappedBy = "role")
    private Set<User> users = new HashSet<>();

*/

    public Role() {}

    public Role(String name) {

        this.name = name;
    }

    public Long getId() {
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

    /*

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
*/

    @Override
    public String toString() {
        return id + ":" + name;
    }
}
