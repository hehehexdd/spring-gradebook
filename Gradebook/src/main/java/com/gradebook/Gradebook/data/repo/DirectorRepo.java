package com.gradebook.Gradebook.data.repo;

import com.gradebook.Gradebook.data.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepo extends JpaRepository<Director, Long> {
}
