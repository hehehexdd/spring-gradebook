package com.gradebook.Gradebook.data.service;

import com.gradebook.Gradebook.data.entity.Director;
import com.gradebook.Gradebook.data.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService{

    @Autowired
    private final DirectorRepo directorRepo;

    public DirectorServiceImpl(DirectorRepo directorRepo) {
        this.directorRepo = directorRepo;
    }

    @Override
    public Director saveDirector(Director director) {
        return directorRepo.save(director);
    }

    @Override
    public void updateDirector(Director director) {
    }

    @Override
    public void deleteDirector(Long id) {
        directorRepo.deleteById(id);
    }

    @Override
    public Director getDirector(Long id) {
        return directorRepo.getById(id);
    }

    @Override
    public List<Director> getDirectors() {
        return directorRepo.findAll();
    }
}
