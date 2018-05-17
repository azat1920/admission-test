package com.netcracker.admissiontest.usersResult.entity;

import com.netcracker.admissiontest.user.entity.User;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "user_result")
public class UserResult {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "correct_answers")
    private Long correctAnswers;

    public UserResult() {
    }

    public UserResult(User user, Long correctAnswers) {
        this.user = user;
        this.correctAnswers = correctAnswers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Long correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
}
