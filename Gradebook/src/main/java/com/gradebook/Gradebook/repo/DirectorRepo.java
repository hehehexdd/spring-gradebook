package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepo extends JpaRepository<Director, Long> {

    Director findByUsername(String username);
}
