package com.netcracker.admissiontest.questionCategory.service;

import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.answer.repository.AnswerRepository;
import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.repository.QuestionRepository;
import com.netcracker.admissiontest.question.service.QuestionService;
import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import com.netcracker.admissiontest.questionCategory.repository.QuestionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionCategoryService {

    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;


    @PostConstruct
    public void init(){
        createQuestionCategory(new QuestionCategory("Java"));
        createQuestionCategory(new QuestionCategory("Web"));
        createQuestionCategory(new QuestionCategory("Linux"));
        createQuestionCategory(new QuestionCategory("Data structures"));
        createQuestionCategory(new QuestionCategory("Databases"));

        QuestionCategory qc_1 = questionCategoryRepository.findByName("Java").get(0);
        QuestionCategory qc_2 = questionCategoryRepository.findByName("Linux").get(0);



        Question q1 = new Question(qc_1, "Чему равен размер int в байтах?");
        Question q2 = new Question(qc_2, "Что выведет команда \"echo 1+1\"");
        Question q3 = new Question(qc_1, "Какая версия JDK является последней?");

        questionRepository.save(q1);
        questionRepository.save(q2);
        questionRepository.save(q3);

        List<Answer> list = new ArrayList<>();

        list.add(new Answer(q1,"4", true));
        list.add(new Answer(q1,"8",false));
        list.add(new Answer(q1, "2", false));

        list.add(new Answer(q2, "2",false));
        list.add(new Answer(q2, "1+1",true));

        list.add(new Answer(q3, "1.7",false));
        list.add(new Answer(q3, "1.8", false));
        list.add(new Answer(q3, "1.9",false));
        list.add(new Answer(q3, "1.10",true));

        for (Answer answer: list
             ) {
            answerRepository.save(answer);
        }



    }



    public List<QuestionCategory> getAll(){
        List<QuestionCategory> list = new ArrayList<>();

        for (QuestionCategory questionCategory:
             questionCategoryRepository.findAll()) {
            list.add(questionCategory);
        }

        return list;
    }

    public QuestionCategory getQuestionCategory(Long id){
        return questionCategoryRepository.findById(id).get();
    }

    public void createQuestionCategory(QuestionCategory questionCategory){
        questionCategoryRepository.save(questionCategory);
    }

    public void updateQuestionCategory(Long id, QuestionCategory questionCategory){
        questionCategoryRepository.save(questionCategory);
    }

    public void deleteQuestionCategory(Long id){
        questionCategoryRepository.deleteById(id);
    }


}
