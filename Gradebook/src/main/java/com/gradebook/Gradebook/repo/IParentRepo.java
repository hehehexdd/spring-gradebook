package com.gradebook.Gradebook.repo;


import com.gradebook.Gradebook.model.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IParentRepo extends JpaRepository<Parent, Long> {
    Parent findByUsername(String username);
}
