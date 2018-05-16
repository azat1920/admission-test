package com.netcracker.admissiontest.constant.service;

import com.netcracker.admissiontest.constant.entity.Constant;
import com.netcracker.admissiontest.constant.repository.ConstantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConstantService {

    @Autowired
    private ConstantRepository constantRepository;


    @PostConstruct
    public void init(){
        Constant constant = new Constant("questionsCount", "20");
        createConstant(constant);
        createConstant(new Constant("passed", "80"));
        createConstant(new Constant("conditionally_passed", "60"));
        createConstant(new Constant("not_passed", "60"));
    }



    public List<Constant> getAll(){

        List<Constant> constants = new ArrayList<>();

        for (Constant constant: constantRepository.findAll()
             ) {
            constants.add(constant);
        }

        return constants;
    }

    public Constant getConstant(Long id){
        return constantRepository.findById(id).get();
    }

    public void createConstant(Constant constant){
        constantRepository.save(constant);
    }

    public  void updateConstante(Long id, Constant constant){
        constantRepository.save(constant);
    }

    public void deleteConstant(Long id){
        constantRepository.deleteById(id);
    }

}
