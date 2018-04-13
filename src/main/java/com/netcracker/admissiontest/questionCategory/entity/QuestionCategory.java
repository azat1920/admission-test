package com.netcracker.admissiontest.questionCategory.entity;


import javax.persistence.*;

@Entity
@Table(name = "question_categories")
public class QuestionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public QuestionCategory(){

    }

    public QuestionCategory(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuestionCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
