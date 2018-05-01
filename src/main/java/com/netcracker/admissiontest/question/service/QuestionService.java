package com.netcracker.admissiontest.question.service;

import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.answer.repository.AnswerRepository;
import com.netcracker.admissiontest.answer.service.AnswerService;
import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.repository.QuestionRepository;
import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import com.netcracker.admissiontest.questionCategory.service.QuestionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionCategoryService questionCategoryService;

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

    public void deleteQuestion(Long id) {
        List<Answer> answers = answerRepository.findAllByQuestion(getQuestion(id));

        for (Answer answer: answers) {
            answerService.deleteAnswer(answer.getId());
        }

        questionRepository.deleteById(id);
    }

    public void createQuestion(Question question){
        questionRepository.save(question);
    }

    public List<Question> getQuestionsByCategoryId(QuestionCategory questionCategory) {
        return questionRepository.findByQuestionCategory(questionCategory);
    }

    public void deleteQuestionByCategory(QuestionCategory questionCategory){


        List<Question> questions = getQuestionsByCategoryId(questionCategory);

        System.out.println(questionCategory.toString());
        for (Question question:questions) {
            System.out.println(question.toString());
            deleteQuestion(question.getId());
        }
    }
}
