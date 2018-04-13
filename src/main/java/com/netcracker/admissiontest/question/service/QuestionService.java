package com.netcracker.admissiontest.question.service;

import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAll(){
        List<Question> questions = new ArrayList<>();
        for (Question question:questionRepository.findAll()) {
            questions.add(question);
        }
        return  questions;
    }

    public Question getQuestion(Long id){
        return questionRepository.findById(id).get();
    }

    public void updateQuestion(Long id, Question question){
        questionRepository.save(question);
    }

    public  void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }

    public void createQuestion(Question question){
        questionRepository.save(question);
    }


}
