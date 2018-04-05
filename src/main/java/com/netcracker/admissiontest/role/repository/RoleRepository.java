package com.netcracker.admissiontest.role.repository;

import com.netcracker.admissiontest.role.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository <Role, Long>{


    List<Role> findByName(String name);

}
