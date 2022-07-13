package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.TermProgramDTO;
import com.gradebook.Gradebook.model.entity.ClassTeachers;
import com.gradebook.Gradebook.model.entity.TermProgram;
import com.gradebook.Gradebook.repo.ClassTeacherRepo;
import com.gradebook.Gradebook.repo.TermProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TermProgramService implements ITermProgramService {

    @Autowired
    private final TermProgramRepo termProgramRepo;

    @Autowired
    private final ClassTeacherRepo classTeacherRepo;

    public TermProgramService(TermProgramRepo termProgramRepo, ClassTeacherRepo classTeacherRepo) {
        this.termProgramRepo = termProgramRepo;
        this.classTeacherRepo = classTeacherRepo;
    }


    @Override
    public TermProgramDTO save(TermProgramDTO termProgramDTO) {
        ClassTeachers classTeachers = classTeacherRepo.getById(termProgramDTO.getId());

        return convertToDTO(new TermProgram(
                null,
                classTeachers,
                termProgramDTO.getTimestamp(),
                termProgramDTO.getWeekDay()
        ));
    }

    @Override
    public List<TermProgramDTO> getAllByClassId(Long id) {
        return termProgramRepo.getAllByClassTeachers_StudentClass_Id(id)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllByClassId(Long id) {
        termProgramRepo.deleteAllByClassTeachers_StudentClass_Id(id);
    }

    @Override
    public TermProgramDTO convertToDTO(TermProgram termProgram) {
        return new TermProgramDTO(
                termProgram.getId(),
                termProgram.getTimestamp(),
                termProgram.getWeekDay(),
                termProgram.getClassTeachers().getId(),
                termProgram.getClassTeachers() != null ? termProgram.getClassTeachers().getStudentClass().getId() : null,
                termProgram.getClassTeachers() != null ? termProgram.getClassTeachers().getStudentClass().getName() : null,
                termProgram.getClassTeachers() != null ? termProgram.getClassTeachers().getTeacher().getId() : null,
                termProgram.getClassTeachers() != null ?
                        termProgram.getClassTeachers().getTeacher().getFirstName() + " " + termProgram.getClassTeachers().getTeacher().getLastName()  : null,
                termProgram.getClassTeachers() != null ? termProgram.getClassTeachers().getSubject().getId() : null,
                termProgram.getClassTeachers() != null ? termProgram.getClassTeachers().getSubject().getName() : null
        );
    }
}
