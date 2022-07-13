package com.gradebook.Gradebook.util;

import com.gradebook.Gradebook.model.dto.DirectorDTO;

import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.Director;
import com.gradebook.Gradebook.model.entity.RoleType;
import org.springframework.http.HttpStatus;

public class Helper {

    private void Helper() {

    }

    public static Director getDirectorEntity() {
        return new Director(
                "testDirector",
                "testDirector@testDirector.com",
                "123",
                RoleType.DIRECTOR,
                false,
                "testDirector",
                "testDirector",
                null
        );
    }
    public static DirectorDTO getDirectorDTO() {
        return new DirectorDTO(
                1L,
                "testDirector",
                "testDirector",
                "testDirector",
                null,
                1L
        );
    }

    public static RegisterDTO getRegisterDTO() {
        return new RegisterDTO (
                "username",
                "email@email.com",
                "password",
                "firstName",
                "lastName",
                RoleType.TEST,
                false,
                1L,
                1L
        );
    }
}
