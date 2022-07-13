package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.*;
import com.gradebook.Gradebook.repo.ClassTeacherRepo;
import com.gradebook.Gradebook.repo.ParentRepo;
import com.gradebook.Gradebook.repo.TeacherRepo;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TeacherServiceTest {


    @Mock
    private TeacherRepo teacherRepo;

    @Mock
    private ClassTeacherRepo classTeacherRepo;

    @Mock
    private IStudentService studentService;

    @Mock
    private ISubjectService subjectService;

    @Mock
    private ISchoolService schoolService;

    @Mock
    private PasswordEncoder passwordEncoder;

    private TeacherService teacherService;

    @BeforeEach
    public void init() {
        ArrayList<ClassTeachers> classTeachers = new ArrayList<>();
        var school = new School();
        Teacher teacher = new Teacher("Tester", "test@gmail.com", "123", RoleType.TEST, true, "Ivan", "Ivanov",school, classTeachers);
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        teachers.add(teacher);

        MockitoAnnotations.openMocks(this);
        this.teacherService = new TeacherService(this.teacherRepo, this.classTeacherRepo, this.studentService, this.subjectService, this.schoolService, this.passwordEncoder);

        when(this.teacherRepo.getById(1L)).thenReturn(teacher);
        when(this.teacherRepo.findAll()).thenReturn(teachers);
        when(this.teacherRepo.findAllBySchool_Id(1L)).thenReturn(teachers);
        when(this.teacherRepo.save(Mockito.any(Teacher.class))).thenReturn(teacher);
        when(this.passwordEncoder.encode("123")).thenReturn("$2a$10$n1042hx1F577X48aw9YdlO/hJUNYRKbZ5WtncghMYmUwK57ZL4Zte");

    }

    @Test
    void createTeacher() {
        RegisterDTO registeredUser = new RegisterDTO("Tester", "test@gmail.com", "123", "Ivan", "Ivanov", RoleType.TEST, true, 4L, 4L);
        var actual = this.teacherService.createTeacher(registeredUser);
        var expected = new TeacherDTO(1L,"Ivan","Ivanov","Tester",1L);
        assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
        assertThat(actual.getFirstName()).isEqualTo(expected.getFirstName());
        assertThat(actual.getLastName()).isEqualTo(expected.getLastName());

    }

    @Test
    void updateWithEmptyTeacher() {
        var payload = new TeacherDTO();
        var actual = this.teacherService.update(1L, payload);
        var expected =  new TeacherDTO(1L,"Ivan","Ivanov","Tester",1L);

        assertThat(actual.getFirstName()).isEqualTo(expected.getFirstName());
        assertThat(actual.getLastName()).isEqualTo(expected.getLastName());
        assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
    }

    @Test
    void getById() {
        var expected = new TeacherDTO(1L,"Ivan","Ivanov","Tester",1L);
        var actual = this.teacherService.getById(1L);

        assertThat(expected.getUsername()).isEqualTo(actual.getUsername());
        assertThat(expected.getFirstName()).isEqualTo(actual.getFirstName());
        assertThat(expected.getLastName()).isEqualTo(actual.getLastName());


    }

    @Test
    void findById() {
        ArrayList<ClassTeachers> classTeachers = new ArrayList<>();
        var school = new School();
        var expectedParent= new Teacher("Tester", "test@gmail.com", "123", RoleType.TEST, true, "Ivan", "Ivanov",school, classTeachers);

        var actual = this.teacherService.findById(1L);

        Assert.assertEquals(expectedParent.getUsername(),actual.getUsername());
        Assert.assertEquals(expectedParent.getFirstName(),actual.getFirstName());
        Assert.assertEquals(expectedParent.getLastName(),actual.getLastName());
        Assert.assertEquals(expectedParent.getClassTeachers(),actual.getClassTeachers());
        Assert.assertEquals(expectedParent.getEmail(),actual.getEmail());
        Assert.assertEquals(expectedParent.getRole(),actual.getRole());
        Assert.assertEquals(expectedParent.getPassword(),actual.getPassword());


    }

    @Test
    void getAll() {
        ArrayList<TeacherDTO> expected = new ArrayList<>();
        var teacher = new TeacherDTO(1L,"Ivan","Ivanov","Tester",1L);
        var actual =  this.teacherService.getAll(1L);
        expected.add(teacher);
        expected.add(teacher);
        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual.get(0).getFirstName()).isEqualTo(expected.get(0).getFirstName());
        assertThat(actual.get(0).getLastName()).isEqualTo(expected.get(0).getLastName());
        assertThat(actual.get(1).getFirstName()).isEqualTo(expected.get(1).getFirstName());
        assertThat(actual.get(1).getLastName()).isEqualTo(expected.get(1).getLastName());


    }

    @Test
    void getCourses() {

    }

    @Test
    void getStudents() {
    }

    @Test
    void getAllBySchoolId() {
        ArrayList<TeacherDTO> expected = new ArrayList<>();
        var teacher = new TeacherDTO(1L,"Ivan","Ivanov","Tester",1L);
        var actual =  this.teacherService.getAllBySchoolId(1L);
        expected.add(teacher);
        expected.add(teacher);
        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual.get(0).getFirstName()).isEqualTo(expected.get(0).getFirstName());
        assertThat(actual.get(0).getLastName()).isEqualTo(expected.get(0).getLastName());
        assertThat(actual.get(1).getFirstName()).isEqualTo(expected.get(1).getFirstName());
        assertThat(actual.get(1).getLastName()).isEqualTo(expected.get(1).getLastName());
    }

    @Test
    void delete() {
        this.teacherService.delete(1L);
        assertThat(1).isEqualTo(1);
    }
}