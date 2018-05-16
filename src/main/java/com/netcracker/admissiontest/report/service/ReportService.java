package com.netcracker.admissiontest.report.service;

import com.netcracker.admissiontest.report.entity.Report;
import com.netcracker.admissiontest.report.repository.ReportRepository;
import com.netcracker.admissiontest.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Report> getAll(){
        List<Report> reports = new ArrayList<>();

        for (Report report: reportRepository.findAll()) {
            reports.add(report);
        }

        return reports;
    }

    public void createReports(List<Report> reports){
        for (Report report: reports) {
            reportRepository.save(report);
        }

    }

    public  List<Report> getAllByUsername(String username){
        List<Report> reports = new ArrayList<>();

        for (Report report: reportRepository.findAllByUser(userRepository.findByName(username).get(0))) {
            reports.add(report);
        }

        return reports;
    }


}
