package com.netcracker.admissiontest.answer.repository;

import com.netcracker.admissiontest.answer.entity.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
