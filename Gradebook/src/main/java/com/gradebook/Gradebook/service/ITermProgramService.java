package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.TermProgramDTO;
import com.gradebook.Gradebook.model.entity.TermProgram;

import java.util.List;

public interface ITermProgramService {
    TermProgramDTO save(TermProgramDTO termProgramDTO);
    List<TermProgramDTO> getAllByClassId(Long id);
    void deleteAllByClassId(Long id);
    List<TermProgramDTO> getAll();

    TermProgramDTO convertToDTO(TermProgram termProgram);
}
