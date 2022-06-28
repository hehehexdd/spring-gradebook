package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.SchoolDTO;
import com.gradebook.Gradebook.model.dto.SchoolStatisticsDTO;
import com.gradebook.Gradebook.model.entity.Grade;
import com.gradebook.Gradebook.model.entity.School;
import com.gradebook.Gradebook.model.entity.Student;
import com.gradebook.Gradebook.repo.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchoolService implements ISchoolService {

    @Autowired
    private final SchoolRepo schoolRepo;

    public SchoolService(SchoolRepo schoolRepo) {
        this.schoolRepo = schoolRepo;
    }

    @Override
    public SchoolDTO save(School school) {
        return convertToDTO(schoolRepo.save(school));
    }

    @Override
    public void update(SchoolDTO schoolDTO) {
        return;
    }

    @Override
    public void delete(Long id) {
        School school = schoolRepo.getById(id);
        schoolRepo.delete(school);
    }

    @Override
    public SchoolStatisticsDTO getStatisticsForSchool(Long id) {
        School school = schoolRepo.getById(id);
        List<Grade> studentsGrades = new ArrayList();
        double averageGrade = 0.0;
        int totalGrades = 0;

        school.getStudents().forEach(student -> studentsGrades.addAll(student.getGrades()));

        for (Grade grade : studentsGrades) {
            averageGrade += grade.getGrade();
            totalGrades++;
        }

        averageGrade /= totalGrades;

        return new SchoolStatisticsDTO (
                school.getId(),
                school.getName(),
                (school.getDirector() != null) ? String.format("&s &s", school.getDirector().getFirstName(), school.getDirector().getLastName()) : null,
                (school.getDirector() != null) ? school.getId() : null,
                school.getTeachers().size(),
                school.getStudents().size(),
                (Double.isNaN(averageGrade)) ? 0 : averageGrade
        );
    }

    @Override
    public SchoolDTO getById(Long id) {
        return convertToDTO(schoolRepo.getById(id));
    }

    @Override
    public School findById(Long id) {
        return schoolRepo.getById(id);
    }

    @Override
    public List<SchoolDTO> getAll() {
        return schoolRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public SchoolDTO convertToDTO(School school) {
        return new SchoolDTO(
                school.getId(),
                school.getAddress(),
                school.getName(),
                (school.getDirector() != null) ? school.getDirector().getUsername() : null,
                (school.getStudents() != null) ? school.getStudents().stream().map(Student::getUsername).collect(Collectors.toList()) : Collections.emptyList()
        );
    }
}
