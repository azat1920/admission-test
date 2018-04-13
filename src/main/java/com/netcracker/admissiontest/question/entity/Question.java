package com.netcracker.admissiontest.question.entity;


import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "question_category_id")
    private QuestionCategory questionCategory;

    @Column(name = "question_str")
    private String questionStr;

    public Question(){

    }

    public Question(QuestionCategory questionCategory, String questionStr) {
        this.questionCategory = questionCategory;
        this.questionStr = questionStr;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionCategory=" + questionCategory +
                ", questionStr='" + questionStr + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(QuestionCategory questionCategory) {
        this.questionCategory = questionCategory;
    }

    public String getQuestionStr() {
        return questionStr;
    }

    public void setQuestionStr(String questionStr) {
        this.questionStr = questionStr;
    }


}
