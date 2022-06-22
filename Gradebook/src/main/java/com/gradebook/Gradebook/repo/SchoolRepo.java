package com.gradebook.Gradebook.repo;


import com.gradebook.Gradebook.model.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {
}
