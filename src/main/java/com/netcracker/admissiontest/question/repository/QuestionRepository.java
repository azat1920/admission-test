package com.netcracker.admissiontest.question.repository;

import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findByQuestionCategory(QuestionCategory questionCategory);
}
