package com.gradebook.Gradebook.service;


import com.gradebook.Gradebook.model.dto.SchoolClassDTO;
import com.gradebook.Gradebook.model.entity.SchoolClass;
import com.gradebook.Gradebook.repo.SchoolClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchoolClassService implements ISchoolClassService{

    @Autowired
    private final SchoolClassRepo schoolClassRepo;

    @Autowired
    private final ISchoolService schoolService;

    public SchoolClassService(SchoolClassRepo schoolClassRepo, ISchoolService schoolService) {
        this.schoolClassRepo = schoolClassRepo;
        this.schoolService = schoolService;
    }

    @Override
    public SchoolClassDTO saveClass(SchoolClassDTO payload) {
        SchoolClass schoolClass = new SchoolClass(
                payload.getName(),
                payload.getClassYear(),
                schoolService.findById(payload.getSchoolId()
                ));
        schoolClassRepo.save(schoolClass);
        return this.convertToDTO(schoolClass);
    }

    @Override
    public void update(Long id, SchoolClassDTO payload) {
        SchoolClass tmp = schoolClassRepo.getById(id);
        if(payload.getClassYear() != null) tmp.setClassYear(payload.getClassYear());
        if(payload.getName() != null) tmp.setName(payload.getName());
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
    public List<SchoolClassDTO> getAllBySchoolId(Long schoolId) {
        List<SchoolClassDTO> schoolClassDTOS = new ArrayList<>();

        this.schoolClassRepo.getAllClassesBySchoolId(schoolId).forEach(schoolClass ->
                schoolClassDTOS.add(convertToDTO(schoolClass))
        );

        return schoolClassDTOS;
    }

    @Override
    public SchoolClassDTO convertToDTO(SchoolClass schoolClass) {
        SchoolClassDTO schoolClassDTO = new SchoolClassDTO();

        if (schoolClass != null) {
            schoolClassDTO.setId(schoolClass.getId());
            schoolClassDTO.setClassYear(schoolClass.getClassYear());
            schoolClassDTO.setName(schoolClass.getName());

        }
        return schoolClassDTO;
    }
}
