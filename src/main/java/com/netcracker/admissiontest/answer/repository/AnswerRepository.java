package com.netcracker.admissiontest.answer.repository;

import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.question.entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findAllByQuestion(Question question);
}
