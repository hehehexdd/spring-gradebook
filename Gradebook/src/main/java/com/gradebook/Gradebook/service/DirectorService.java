package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.model.entity.Director;
import com.gradebook.Gradebook.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DirectorService implements IDirectorService {

    @Autowired
    private final DirectorRepo directorRepo;

    public DirectorService(DirectorRepo directorRepo) {
        this.directorRepo = directorRepo;
    }

    @Override
    public Director save(Director director) {
        return  directorRepo.save(director);
    }

    @Override
    public void update(Director director) {
        directorRepo.save(director);
    }

    @Override
    public void delete(Long id) {
        directorRepo.deleteById(id);
    }

    @Override
    public DirectorDTO getById(Long id) {
        return convertToDTO(directorRepo.getById(id));
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
