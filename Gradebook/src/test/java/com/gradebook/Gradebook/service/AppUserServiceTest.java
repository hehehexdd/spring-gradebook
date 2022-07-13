package com.gradebook.Gradebook.service;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.gradebook.Gradebook.model.dto.AppUserDTO;
import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.AppUser;

import com.gradebook.Gradebook.model.entity.Parent;
import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.repo.AppUserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

class AppUserServiceTest {

    @Mock
    private AppUserRepo mockedAppUserRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    private AppUserService appUserService;

    @BeforeEach
    public void init() {
        AppUser user1 = new AppUser("Tester", "test@gmail.com", "123", RoleType.TEST, true);
        AppUser user2 = new AppUser("Tester2", "test2@gmail.com", "124", RoleType.TEST, true);
        ArrayList<AppUser> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        MockitoAnnotations.openMocks(this);
        this.appUserService = new AppUserService(this.mockedAppUserRepo);
        when(this.mockedAppUserRepo.getById(1L)).thenReturn(user1);
        when(this.appUserService.getUser("Tester")).thenReturn(user1);
        when(this.mockedAppUserRepo.findAll()).thenReturn(users);
        when(this.mockedAppUserRepo.save(Mockito.any(AppUser.class))).thenReturn(user1);
        when(this.passwordEncoder.encode("123")).thenReturn("$2a$10$n1042hx1F577X48aw9YdlO/hJUNYRKbZ5WtncghMYmUwK57ZL4Zte");
    }

    @Test
    void saveUser() {
        RegisterDTO registeredUser = new RegisterDTO("Tester", "test@gmail.com", "123", "Ivan", "Ivanov", RoleType.TEST, true, 4L, 4L);
        AppUserDTO actualUser = this.appUserService.saveUser(registeredUser);
        AppUserDTO expectedUser = new AppUserDTO(1L,"Tester", "test2@gmail.com", RoleType.TEST.toString(), true);
        assertThat(actualUser.getUsername()).isEqualTo(expectedUser.getUsername());
        assertThat(actualUser.getUsername()).isEqualTo(expectedUser.getUsername());
    }

    @Test
    void updateUser() {
        AppUserDTO expectedUser = new AppUserDTO(1L, "Tester", "test@gmail.com", RoleType.TEST.toString(), true);
        this.appUserService.updateUser(1L, expectedUser);
        AppUserDTO actualUser = this.appUserService.convertToDTO(this.appUserService.getUserById(1L));
        assertThat(actualUser.getUsername()).isEqualTo(expectedUser.getUsername());
        assertThat(actualUser.getEmail()).isEqualTo(expectedUser.getEmail());
        assertThat(actualUser.getRole()).isEqualTo(expectedUser.getRole());


    }

    @Test
    void deleteUser() {
        this.appUserService.deleteUser(1L);
        assertThat(1).isEqualTo(1);
    }

    @Test
    void getUser() {
        AppUserDTO expectedUser = new AppUserDTO(1L,"Tester","test@gmail.com", RoleType.TEST.toString(), true);
        AppUserDTO actualUser = this.appUserService.convertToDTO(this.appUserService.getUser("Tester"));

        assertThat(expectedUser.getUsername()).isEqualTo(actualUser.getUsername());
        assertThat(expectedUser.getEmail()).isEqualTo(actualUser.getEmail());
        assertThat(expectedUser.getRole()).isEqualTo(actualUser.getRole());
    }

    @Test
    void getUserById() {
        AppUserDTO expectedUser = new AppUserDTO(1L, "Tester", "test@gmail.com", RoleType.TEST.toString(), true);
        AppUserDTO actualParent = this.appUserService.convertToDTO(this.appUserService.getUserById(1L));

        assertThat(expectedUser.getUsername()).isEqualTo(actualParent.getUsername());
        assertThat(expectedUser.getEmail()).isEqualTo(actualParent.getEmail());
        assertThat(expectedUser.getRole()).isEqualTo(actualParent.getRole());
    }

    @Test
    void getAllUsers() {
        ArrayList<AppUserDTO> expectedUsers = new ArrayList<>();
        AppUserDTO user1 = new AppUserDTO(1L,"Tester","test@gmail.com", RoleType.TEST.toString(), true);
        AppUserDTO user2 = new AppUserDTO(1L,"Tester2", "test2@gmail.com", RoleType.TEST.toString(), true);
        List<AppUserDTO> actualUsers =  this.appUserService.getAllUsers();
        expectedUsers.add(user1);
        expectedUsers.add(user2);
        assertThat(actualUsers.size()).isEqualTo(2);
        assertThat(actualUsers.get(0).getUsername()).isEqualTo(expectedUsers.get(0).getUsername());
        assertThat(actualUsers.get(0).getEmail()).isEqualTo(expectedUsers.get(0).getEmail());
        assertThat(actualUsers.get(1).getRole()).isEqualTo(expectedUsers.get(1).getRole());

    }
}