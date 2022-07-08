package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.SchoolDTO;
import com.gradebook.Gradebook.model.dto.SchoolStatisticsDTO;
import com.gradebook.Gradebook.model.entity.Grade;
import com.gradebook.Gradebook.model.entity.School;
import com.gradebook.Gradebook.model.entity.Student;
import com.gradebook.Gradebook.model.entity.Teacher;
import com.gradebook.Gradebook.repo.GradeRepo;
import com.gradebook.Gradebook.repo.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchoolService implements ISchoolService {

    @Autowired
    private final SchoolRepo schoolRepo;

    @Autowired
    private final GradeRepo gradeRepo;

    public SchoolService(SchoolRepo schoolRepo, GradeRepo gradeRepo) {
        this.schoolRepo = schoolRepo;
        this.gradeRepo = gradeRepo;
    }

    @Override
    public School save(School school) {
        return schoolRepo.save(school);
    }

    @Override
    public SchoolDTO create(RegisterDTO payload) {
        return convertToDTO(save(new School(
                payload.getAddress(),
                payload.getName()
        )));
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
    public ResponseEntity getGradeStatistics(Long schoolId) {
        Map<String, Integer> gradeStatistics = new HashMap<String, Integer>();

        for (int grade = 2; grade <= 6; grade++) {
            gradeStatistics.put(
                    String.valueOf(grade),
                    gradeRepo.getAllByStudent_School_IdAndGrade(schoolId, grade).size()
            );
        }

        return new ResponseEntity(gradeStatistics, HttpStatus.OK);
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
                (school.getStudents() != null) ? school.getStudents().stream().map(Student::getUsername).collect(Collectors.toList()) : Collections.emptyList(),
                (school.getTeachers() != null) ? school.getTeachers().stream().map(Teacher::getUsername).collect(Collectors.toList()) : Collections.emptyList()
        );
    }
}
