package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.entity.Parent;
import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.repo.ParentRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

import java.util.Optional;


class ParentServiceTest {
    @Mock
    private ParentRepo mockedParentRepo;

    private ParentService parentService;

    @BeforeEach
    public void init() {
        Parent parent= new Parent("Tester", "test@gmail.com", "123", RoleType.TEST, true, "Ivan", "Ivanov");

        MockitoAnnotations.openMocks(this);
        this.parentService = new ParentService(this.mockedParentRepo);
        when(this.mockedParentRepo.getById(1L)).thenReturn(parent);

    }
    @Test
    void createParent() {

    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void testCreateParent() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void getById() {
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
    }

    @Test
    void convertToDTO() {
    }
}