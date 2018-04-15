package com.netcracker.admissiontest.answer.service;

import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.answer.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> getAll(){

        List<Answer> answers = new ArrayList<>();

        for (Answer answer: answerRepository.findAll()) {
            answers.add(answer);
        }

        return answers;

    }


    public Answer getAnswer(Long id){
        return answerRepository.findById(id).get();
    }

    public void updateAnswer(Long id, Answer answer){
        answerRepository.save(answer);
    }

    public void createAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public void deleteAnswer(Long id){
        answerRepository.deleteById(id);
    }

}