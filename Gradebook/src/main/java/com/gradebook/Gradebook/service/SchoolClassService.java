package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.SchoolClassDTO;
import com.gradebook.Gradebook.model.entity.School;
import com.gradebook.Gradebook.model.entity.SchoolClass;
import com.gradebook.Gradebook.repo.SchoolClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SchoolClassService implements ISchoolClassService{

    @Autowired
    private final SchoolClassRepo schoolClassRepo;

    public SchoolClassService(SchoolClassRepo schoolClassRepo) {
        this.schoolClassRepo = schoolClassRepo;
    }

    @Override
    public SchoolClass save(SchoolClass schoolClass) {
        return schoolClassRepo.save(schoolClass);
    }

    @Override
    public void update(SchoolClass schoolClass) {
        SchoolClass tmp = schoolClassRepo.getById(schoolClass.getId());
        tmp.setClassYear(schoolClass.getClassYear());
        tmp.setName(schoolClass.getName());
        schoolClassRepo.save(tmp);
    }

    @Override
    public void delete(Long id) {
        schoolClassRepo.deleteById(id);
    }

    @Override
    public SchoolClassDTO getById(Long id) {
        return this.convertToDTO(schoolClassRepo.getById(id));
    }

    @Override
    public SchoolClass findById(Long id) {
        return schoolClassRepo.getById(id);
    }

    @Override
    public List<SchoolClassDTO> getAll() {
        List<SchoolClassDTO> schoolClassDTOS = new ArrayList<>();

        this.schoolClassRepo.findAll().forEach(sc ->
                schoolClassDTOS.add(convertToDTO(sc))
        );

        return schoolClassDTOS;
    }

    @Override
    public SchoolClassDTO convertToDTO(SchoolClass schoolClass) {
        return null;
    }
}
