package com.netcracker.admissiontest.question.entity;


import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Question implements Comparable<Question>{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne()
    @Cascade(CascadeType.DELETE)
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


    @Override
    public int compareTo(Question o) {
        return (int) (this.id - o.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }

        Question q = (Question) obj;
        return this.id.equals(q.id);
    }
}
