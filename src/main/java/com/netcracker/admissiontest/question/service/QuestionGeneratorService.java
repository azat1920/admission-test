package com.netcracker.admissiontest.question.service;

import com.netcracker.admissiontest.constant.repository.ConstantRepository;
import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.repository.QuestionRepository;
import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import com.netcracker.admissiontest.questionCategory.repository.QuestionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionGeneratorService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;

    @Autowired
    private ConstantRepository constantRepository;

    public Long getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(Long questionsCount) {
        this.questionsCount = questionsCount;
    }

    private Long questionsCount;


    private String[] questionCategory = new String[]{
            "Java", "Web","Linux", "Data structures","Databases"
    };


    public List<Question> getRandomQuestions(){


        questionsCount =  Long.parseLong(constantRepository.findByName("questionsCount").getValue());// new Long(20); //

        Set<Question> questions = new TreeSet<>();            //сет уникальных вопросов
        long questionsInCategoryCount = questionsCount / 5;   //количество вопросов на категорию
        int randomId;                                         //рандомный вопрос из текущей категории
        int categoryId = 0;                                   //айди текущей категории
        List<Question> questionsByCategoryId;                 //вопросы текущей категории

        //пока размер сета меньше количества вопросов
        while(questions.size() < questionsCount)
        {
            //получаем вопросы текущей категории
            questionsByCategoryId = questionRepository.findByQuestionCategory(getCategoryById(categoryId));

            do{
                //получаем рандомное число от 0 до количества вопросов текущей категории
                randomId = new Random().nextInt(questionsByCategoryId.size());
                //получаем вопрос по рандомному айди
                Question q = questionsByCategoryId.get(randomId);
                System.out.println("categoryId: "+ categoryId +" Rand: " + randomId + " Question: " +q.toString());
                //если вопроса нет в сете, он добавится
                questions.add(q);

                //добавляем вопросы текущей категории до тех пор, пока размер сета не будет кратен
                // количеству вопросов на категорию
            }while ( (questions.size() % questionsInCategoryCount) != 0);

            categoryId++; //инкремент айди категории

        }

        return new ArrayList<>(questions);
    }

    private QuestionCategory getCategoryById(int id){

        QuestionCategory qc = questionCategoryRepository.findByName(questionCategory[id]).get(0);
        return qc;
    }

}
