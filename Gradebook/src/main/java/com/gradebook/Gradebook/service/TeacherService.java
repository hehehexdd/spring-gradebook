package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.Teacher;
import com.gradebook.Gradebook.repo.ITeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class TeacherService implements ITeacherService{
    @Autowired
    private final ITeacherRepo teacherRepo;

    public TeacherService(ITeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return this.teacherRepo.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        this.teacherRepo.save(teacher);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = this.teacherRepo.getById(id);
        this.teacherRepo.delete(teacher);
    }

    @Override
    public TeacherDTO getById(Long id) {
        Teacher teacher = this.teacherRepo.getById(id);
        return this.convertToDTO(teacher);
    }

    @Override
    public List<TeacherDTO> getAll() {

        List<TeacherDTO> teacherDTOS = new ArrayList<>();

        this.teacherRepo.findAll().forEach(teacher ->
                teacherDTOS.add(convertToDTO(teacher))
        );

        return teacherDTOS;
    }

    @Override
    public TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();

        if (teacher != null) {
            teacherDTO.setUsername(teacher.getUsername());
            teacherDTO.setFirstName(teacher.getFirstName());
            teacherDTO.setLastName(teacher.getLastName());
            teacherDTO.setUsername(teacher.getUsername());
            teacherDTO.setSchoolId(teacher.getSchool().getId());
            //to do add teacher_classes
        }

        return teacherDTO;
    }
}
