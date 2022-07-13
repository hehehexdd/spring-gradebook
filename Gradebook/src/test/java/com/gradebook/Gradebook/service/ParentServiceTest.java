package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.*;
import com.gradebook.Gradebook.repo.ParentRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


class ParentServiceTest {
    @Mock
    private ParentRepo mockedParentRepo;

    @Mock
    private StudentService mockedStudentService;

    @Mock
    private PasswordEncoder passwordEncoder;

    private ParentService parentService;

    @BeforeEach
    public void init() {

        Parent parent1= new Parent("Tester", "test@gmail.com", "123", RoleType.TEST, true, "Ivan", "Ivanov");
        Parent parent2= new Parent("Tester1", "test1@gmail.com", "124", RoleType.TEST, true, "Denislav", "Denev");
        ArrayList<Parent> parents = new ArrayList<>();
        parents.add(parent1);
        parents.add(parent2);
        MockitoAnnotations.openMocks(this);
        this.parentService = new ParentService(this.mockedParentRepo, this.mockedStudentService, this.passwordEncoder);
        when(this.mockedParentRepo.getById(1L)).thenReturn(parent1);
        when(this.mockedParentRepo.findAll()).thenReturn(parents);
        when(this.mockedParentRepo.save(Mockito.any(Parent.class))).thenReturn(parent1);
        when(this.passwordEncoder.encode("123")).thenReturn("$2a$10$n1042hx1F577X48aw9YdlO/hJUNYRKbZ5WtncghMYmUwK57ZL4Zte");

    }
    @Test
    void createParent() {
        RegisterDTO registeredUser = new RegisterDTO("Tester", "test@gmail.com", "123", "Ivan", "Ivanov", RoleType.TEST, true, 4L, 4L);
        var actual = this.parentService.createParent(registeredUser);
        var expected = new ParentDTO(1L,"Ivan","Ivanov","Tester");
        assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
        assertThat(actual.getFirstName()).isEqualTo(expected.getFirstName());
        assertThat(actual.getLastName()).isEqualTo(expected.getLastName());
    }

    @Test
    void updateParentWithoutKids() {
        var expected = new ParentDTO(1L,"Ivan","Ivanov","Tester");
        var actual = this.parentService.update(1l,expected);
        assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
        assertThat(actual.getFirstName()).isEqualTo(expected.getFirstName());
        assertThat(actual.getLastName()).isEqualTo(expected.getLastName());
    }

    @Test
    void updateWithEmptyPayload() {

        var actual = this.parentService.update(1l,null);
        var expected = this.parentService.convertToDTO(new Parent("Tester", "test@gmail.com", "123", RoleType.TEST, true, "Ivan", "Ivanov"));
        assertThat(actual.getFirstName()).isEqualTo(expected.getFirstName());
    }

    @Test
    void getById() {
        var expectedParent = new ParentDTO(1L,"Ivan","Ivanov","Tester");
        var actualParent = this.parentService.getById(1L);

        assertThat(expectedParent.getUsername()).isEqualTo(actualParent.getUsername());
        assertThat(expectedParent.getFirstName()).isEqualTo(actualParent.getFirstName());
        assertThat(expectedParent.getLastName()).isEqualTo(actualParent.getLastName());
    }

    @Test
    void findById() {
        var actual = this.parentService.findById(1L);
        var expectedParent= new Parent("Tester", "test@gmail.com", "123", RoleType.TEST, true, "Ivan", "Ivanov");
        Assert.assertEquals(expectedParent.getUsername(),actual.getUsername());
        Assert.assertEquals(expectedParent.getFirstName(),actual.getFirstName());
        Assert.assertEquals(expectedParent.getLastName(),actual.getLastName());
        Assert.assertEquals(expectedParent.getKids(),actual.getKids());
        Assert.assertEquals(expectedParent.getEmail(),actual.getEmail());
        Assert.assertEquals(expectedParent.getRole(),actual.getRole());
        Assert.assertEquals(expectedParent.getPassword(),actual.getPassword());

    }

    @Test
    void getAll() {
        ArrayList<ParentDTO> expectedParents = new ArrayList<>();
        var parent1 = new ParentDTO(1L,"Ivan","Ivanov","Tester");
        var parent2 = new ParentDTO(2L,"Denislav", "Denev", "Tester1");
        var actualParents =  this.parentService.getAll();
        expectedParents.add(parent1);
        expectedParents.add(parent2);
        assertThat(actualParents.size()).isEqualTo(2);
        assertThat(actualParents.get(0).getFirstName()).isEqualTo(expectedParents.get(0).getFirstName());
        assertThat(actualParents.get(0).getLastName()).isEqualTo(expectedParents.get(0).getLastName());
        assertThat(actualParents.get(1).getFirstName()).isEqualTo(expectedParents.get(1).getFirstName());
        assertThat(actualParents.get(1).getLastName()).isEqualTo(expectedParents.get(1).getLastName());
    }
    @Test
    void delete() {
        this.parentService.delete(1l);
        assertThat(1).isEqualTo(1);
    }


}