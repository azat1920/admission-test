package com.netcracker.admissiontest.questionCategory.repository;

import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import com.netcracker.admissiontest.role.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionCategoryRepository extends CrudRepository<QuestionCategory, Long> {

    List<QuestionCategory>  findByName(String name);
}
