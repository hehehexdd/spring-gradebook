package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.exception.EntityNotFoundException;
import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.Director;
import com.gradebook.Gradebook.model.entity.School;
import com.gradebook.Gradebook.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DirectorService implements IDirectorService {

    @Autowired
    private final DirectorRepo directorRepo;

    @Autowired
    private final ISchoolService schoolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DirectorService(DirectorRepo directorRepo, ISchoolService schoolService) {
        this.directorRepo = directorRepo;
        this.schoolService = schoolService;
    }

    //TO-DO
    @Override
    public void update(Long id, RegisterDTO registerDTO) {
        Director director = directorRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Director not found!"));

        director.setUsername((registerDTO.getUsername() != null) ? registerDTO.getUsername() : director.getUsername());
        director.setEmail((registerDTO.getEmail() != null) ? registerDTO.getEmail() : director.getEmail());
        director.setPassword((registerDTO.getPassword() != null) ? registerDTO.getPassword() : director.getPassword());
        director.setRole((registerDTO.getRole() != null) ? registerDTO.getRole() : director.getRole());
        director.setAccountLocked(registerDTO.isAccountLocked());
        director.setFirstName((registerDTO.getFirstName() != null) ? registerDTO.getFirstName() : director.getFirstName());
        director.setLastName((registerDTO.getLastName() != null) ? registerDTO.getLastName() : director.getLastName());
        director.setSchool((registerDTO.getSchoolId() != null) ? schoolService.findById(registerDTO.getSchoolId()) : director.getSchool());
    }

    @Override
    public Director save(Director director) {
        return directorRepo.save(director);
    }

    @Override
    public DirectorDTO create(RegisterDTO payload) {

        return convertToDTO(save(new Director(
                payload.getUsername(),
                payload.getEmail(),
                passwordEncoder.encode(payload.getPassword()),
                payload.getRole(),
                false,
                payload.getFirstName(),
                payload.getLastName(),
                schoolService.findById(payload.getSchoolId())
        )));
    }

    @Override
    public void delete(Long id) {
        directorRepo.deleteById(id);
    }

    @Override
    public Director findById(Long id) {
        return directorRepo.getById(id);
    }

    @Override
    public Director findByUsername(String username) {
        return directorRepo.findByUsername(username);
    }

    @Override
    public DirectorDTO getById(Long id) {
        Optional<Director> director = directorRepo.findById(id);

        if (!director.isPresent()) {
            throw new EntityNotFoundException(String.format("Director with id '%d' not found!", id));
        }

        return convertToDTO(director.get());
    }

    public DirectorDTO getByUsername(String username) {
        return convertToDTO(directorRepo.findByUsername(username));
    }

    @Override
    public List<DirectorDTO> getAll() {
        List<DirectorDTO> directorDTOS = new ArrayList<>();

        directorRepo.findAll().forEach(director ->
            directorDTOS.add(convertToDTO(director))
        );

        return directorDTOS;
    }

    @Override
    public DirectorDTO convertToDTO(Director director) {
        DirectorDTO directorDTO = new DirectorDTO();

        if (director != null) {
            directorDTO.setId(director.getId());
            directorDTO.setFirstName(director.getFirstName());
            directorDTO.setLastName(director.getLastName());
            directorDTO.setUsername(director.getUsername());
            directorDTO.setSchool(director.getSchool().getName());
        }

        return directorDTO;
    }

}
