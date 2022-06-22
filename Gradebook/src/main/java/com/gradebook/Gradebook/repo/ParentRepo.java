package com.gradebook.Gradebook.repo;


import com.gradebook.Gradebook.model.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Long> {
    Parent findByUsername(String username);
}
