package com.netcracker.admissiontest.report.repository;

import com.netcracker.admissiontest.report.entity.Report;
import com.netcracker.admissiontest.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReportRepository extends CrudRepository<Report, Long> {
    List<Report> findAllByUser(User user);
}
