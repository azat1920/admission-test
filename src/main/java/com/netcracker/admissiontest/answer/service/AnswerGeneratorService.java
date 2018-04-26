package com.netcracker.admissiontest.answer.service;


import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.answer.repository.AnswerRepository;
import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.service.QuestionGeneratorService;
import com.netcracker.admissiontest.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerGeneratorService {


    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionGeneratorService questionGeneratorService;

    public Map<Question, Set<Answer>> getGeneratedTest(){
        Map<Question, Set<Answer>> collection = new TreeMap<>();
        Set<Answer> answers;


        List<Question> questions = questionGeneratorService.getRandomQuestions();

        for (Question question: questions) {

            answers = new HashSet<>(answerRepository.findAllByQuestion(question));
            collection.put(question, answers);


        }

        return collection;

    }


}
