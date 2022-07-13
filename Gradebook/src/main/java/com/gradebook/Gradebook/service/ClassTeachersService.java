package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.ClassTeachersDTO;
import com.gradebook.Gradebook.model.entity.ClassTeachers;
import com.gradebook.Gradebook.repo.ClassTeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClassTeachersService implements IClassTeachersService {

    @Autowired
    private final ClassTeacherRepo classTeacherRepo;

    @Autowired
    private final ISchoolClassService schoolClassService;

    @Autowired
    private final ITeacherService teacherService;

    @Autowired
    private final ISubjectService subjectService;

    public ClassTeachersService(ClassTeacherRepo classTeacherRepo, ISchoolClassService schoolClassService,
                         ITeacherService teacherService, ISubjectService subjectService) {
        this.classTeacherRepo = classTeacherRepo;
        this.schoolClassService = schoolClassService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @Override
    public ClassTeachersDTO saveClassTeachers(ClassTeachersDTO payload) {
        ClassTeachers classTeachers = new ClassTeachers(
                schoolClassService.findById(payload.getClassId()),
                teacherService.findById(payload.getTeacherId()),
                subjectService.findSubjectById(payload.getSubjectId())
        );
        classTeacherRepo.save(classTeachers);
        return this.convertToDTO(classTeachers);
    }

    @Override
    public void update(ClassTeachersDTO payload) {
        ClassTeachers classTeachers = classTeacherRepo.getById(payload.getId());
        if (payload.getClassId() != null) classTeachers.setStudentClass(schoolClassService.findById(payload.getClassId()));
        if (payload.getTeacherId() != null) classTeachers.setTeacher(teacherService.findById(payload.getTeacherId()));
        if (payload.getSubjectId() != null) classTeachers.setSubject(subjectService.findSubjectById(payload.getSubjectId()));
        this.classTeacherRepo.save(classTeachers);
    }

    @Override
    public void delete(Long id) {
        this.classTeacherRepo.deleteById(id);
    }

    @Override
    public ClassTeachersDTO getById(Long id) {
        return this.convertToDTO(classTeacherRepo.getById(id));
    }

    @Override
    public ClassTeachers findById(Long id) {
        return classTeacherRepo.getById(id);
    }

    @Override
    public List<ClassTeachersDTO> getAll() {
        return classTeacherRepo.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClassTeachersDTO convertToDTO(ClassTeachers classTeachers) {
        ClassTeachersDTO classTeachersDTO = new ClassTeachersDTO();

        if (classTeachers != null) {
            classTeachersDTO.setId(classTeachers.getId());
            classTeachersDTO.setClassId(classTeachers.getSubject().getId());
            classTeachersDTO.setClassName(classTeachers.getStudentClass().getName());
            classTeachersDTO.setTeacherId(classTeachers.getTeacher().getId());
            classTeachersDTO.setTeacherName(classTeachers.getTeacher().getFirstName() + " " + classTeachers.getTeacher().getLastName());
            classTeachersDTO.setSubjectId(classTeachers.getSubject().getId());
            classTeachersDTO.setSubjectName(classTeachers.getSubject().getName());
        }
        return classTeachersDTO;
    }
}
