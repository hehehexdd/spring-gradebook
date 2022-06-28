package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.TeacherCourcesDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.Teacher;
import com.gradebook.Gradebook.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Service
public class TeacherService implements ITeacherService{
    @Autowired
    private final TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
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
    public List<TeacherDTO> getAll(Long schoolId) {
        if (schoolId != null) {
            return teacherRepo.findAllBySchool_Id(schoolId)
                    .stream().map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        return teacherRepo.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherCourcesDTO> getCourses(Long id) {
        List<TeacherCourcesDTO> courses= new ArrayList<>();
        //to add logic
        courses.add(new TeacherCourcesDTO(id,"Physics 4th Grade",Long.valueOf(5)));
        courses.add(new TeacherCourcesDTO(id,"Mathematics 7th Grade",Long.valueOf(4)));

        return courses;
    }

    @Override
    public TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();

        if (teacher != null) {
            teacherDTO.setId(teacher.getId());
            teacherDTO.setUsername(teacher.getUsername());
            teacherDTO.setFirstName(teacher.getFirstName());
            teacherDTO.setLastName(teacher.getLastName());
            teacherDTO.setUsername(teacher.getUsername());
            teacherDTO.setSchoolId((teacher.getSchool() != null) ? teacher.getSchool().getId() : null);
            //to do add teacher_classes
        }

        return teacherDTO;
    }
}
