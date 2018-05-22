package com.netcracker.admissiontest.answer.service;

import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.answer.repository.AnswerRepository;
import com.netcracker.admissiontest.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

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
        if (answer.getAnswerStr().length() > 0) answerRepository.save(answer);
    }

    public void deleteAnswer(Long id){
        answerRepository.deleteById(id);
    }

    public List<Answer> getAnswerByQuestionId(Long id){
        List<Answer> answers = new ArrayList<>();

        for (Answer answer:answerRepository.findAllByQuestion(questionRepository.findById(id).get())) {
            answers.add(answer);
        }
        return  answers;
    }


    public Long checkCorrectAnswers(List<Answer> answers){
        Long count = new Long(0);

        for (Answer answer: answers) {
            if (answer.isCorrect()) count++;
        }

        return count;
    }

    public List<Answer> getAllCorrectAnswers(){

        List<Answer> answers = new ArrayList<>();

        for (Answer answer: answerRepository.findAll()) {
            if (answer.isCorrect())
            answers.add(answer);
        }

        return answers;

    }

}
