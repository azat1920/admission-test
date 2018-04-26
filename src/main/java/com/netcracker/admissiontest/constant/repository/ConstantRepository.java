package com.netcracker.admissiontest.constant.repository;


import com.netcracker.admissiontest.constant.entity.Constant;
import org.springframework.data.repository.CrudRepository;


public interface ConstantRepository extends CrudRepository<Constant, Long> {
    public Constant findByName(String name);
}
