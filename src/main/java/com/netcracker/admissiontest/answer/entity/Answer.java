package com.netcracker.admissiontest.answer.entity;

import com.netcracker.admissiontest.question.entity.Question;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @Cascade(CascadeType.DELETE)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "answer_str")
    private String answerStr;

    @Column(name = "is_correct")
    private boolean isCorrect;

    public Answer() {
    }

    public Answer(Question question, String answerStr, boolean isCorrect) {
        this.question = question;
        this.answerStr = answerStr;
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", question=" + question +
                ", answerStr='" + answerStr + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswerStr() {
        return answerStr;
    }

    public void setAnswerStr(String answerStr) {
        this.answerStr = answerStr;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
