package com.netcracker.admissiontest.role.service;

import com.netcracker.admissiontest.role.entity.Role;
import com.netcracker.admissiontest.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public void createRole(Role role) {
         roleRepository.save(role);
    }

    public List<Role> getAll(){
        List <Role> list = new ArrayList<>();
        for(Role role : roleRepository.findAll()) {
            list.add(role);
        }
        return list;
    }

    public Role getRole(long id){
        return roleRepository.findById(id).get();
    }

    public void updateRole(Long id, Role role){
        roleRepository.save(role);
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }
}
