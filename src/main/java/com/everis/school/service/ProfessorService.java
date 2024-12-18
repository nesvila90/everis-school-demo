package com.everis.school.service;

import com.everis.school.model.Professor;
import com.everis.school.model.Subject;
import com.everis.school.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Page<Subject> findSubjectByProfessorId(Long id, Pageable pageable) {
        return professorRepository.findSubjectsByProfessorId(id, pageable);
    }


}
