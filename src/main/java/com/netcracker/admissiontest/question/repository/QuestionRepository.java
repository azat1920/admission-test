package com.netcracker.admissiontest.question.repository;

import com.netcracker.admissiontest.question.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
