package com.gradebook.Gradebook.data.service;

import com.gradebook.Gradebook.data.entity.Director;

import java.util.List;

public interface DirectorService {
    Director saveDirector(Director director);
    void updateDirector(Director director);
    void deleteDirector(Long id);
    Director getDirector(Long id);
    List<Director> getDirectors();
}
