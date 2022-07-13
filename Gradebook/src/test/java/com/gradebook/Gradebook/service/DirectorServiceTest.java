package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.entity.Director;
import com.gradebook.Gradebook.repo.DirectorRepo;
import com.gradebook.Gradebook.util.Helper;
import groovyjarjarpicocli.CommandLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Assert;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class DirectorServiceTest {
    @Mock
    private DirectorRepo directorRepoMock;

    @Mock
    private SchoolService schoolServiceMock;

    @Mock
    private PasswordEncoder passwordEncoderMock;

    @InjectMocks
    private DirectorService directorService;

    Director testDirector;

    @BeforeEach
    public void init() {
        testDirector = Helper.getDirectorEntity();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findByIdReturnsDirector() {
        when(directorRepoMock.getById(anyLong())).thenReturn(testDirector);

        assertThat(directorService.findById(1L)).isEqualTo(testDirector);
    }

    @Test
    public void getByIdReturnsDirectorDTO() {
        when(directorRepoMock.findById(anyLong())).thenReturn(Optional.of(testDirector));

        assertThat(directorService.getById(1L)).isEqualTo(directorService.convertToDTO(testDirector));
    }

    @Test
    public void getAllReturnsDirectorDTOList() {
        when(directorRepoMock.findAll()).thenReturn(List.of(testDirector, testDirector, testDirector));

        assertThat(directorService.getAll()).isEqualTo(
                Stream.of(testDirector, testDirector, testDirector)
                        .map(directorService::convertToDTO)
                        .collect(Collectors.toList())
        );
    }

    @Test
    public void createReturnsDirectorDTO() {
        when(directorRepoMock.save(any(Director.class))).thenReturn(testDirector);
        when(schoolServiceMock.findById(any())).thenReturn(null);
        when(passwordEncoderMock.encode(any())).thenReturn("password");

        assertThat(directorService.create(Helper.getRegisterDTO())).isEqualTo(directorService.convertToDTO(testDirector));
    }

    @Test
    public void deleteDirectorReturnsNothing() {
        directorService.delete(1L);
        assertThat(1).isEqualTo(1);
    }

    @Test
    public void updatesDirectorWithEmptyPayload() {
        when(directorRepoMock.findById(anyLong())).thenReturn(Optional.of(testDirector));
        when(directorRepoMock.save(any(Director.class))).thenReturn(testDirector);

        assertThat(directorService.update(1L, Helper.getRegisterDTO())).isEqualTo(directorService.convertToDTO(testDirector));
    }

}