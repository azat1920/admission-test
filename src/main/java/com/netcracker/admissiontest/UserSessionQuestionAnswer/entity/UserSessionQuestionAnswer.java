package com.netcracker.admissiontest.UserSessionQuestionAnswer.entity;

import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.userSession.entity.UserSession;

import javax.persistence.*;

@Entity
@Table(name = "User_Session_Question_Answer")
public class UserSessionQuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_session_id")
    private UserSession userSession;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name="answer_id")
    private Answer answer;

    public UserSessionQuestionAnswer() {
    }

    public UserSessionQuestionAnswer(UserSession userSession, Question question, Answer answer) {
        this.userSession = userSession;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserSessionQuestionAnswerRepository{" +
                "id=" + id +
                ", userSession=" + userSession +
                ", question=" + question +
                ", answer=" + answer +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
