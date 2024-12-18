package com.everis.school.api.controller;

import com.everis.school.model.Professor;
import com.everis.school.model.Subject;
import com.everis.school.service.ProfessorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/professor")
public class ProfessorController {


    private final ProfessorService professorService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProfessorController(ProfessorService professorService, ObjectMapper objectMapper) {
        this.professorService = professorService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> fetchAll() throws JsonProcessingException {
        List<Professor> all = professorService.findAll();
        String s = objectMapper.writeValueAsString(all);
        log.info("Professor find all - Content:{}", s);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}/subjects")
    public Page<Subject> getAsignaturasByProfesor(@PathVariable Long id, Pageable pageable) throws JsonProcessingException {
        Page<Subject> subjectByProfessorId = professorService.findSubjectByProfessorId(id, pageable);

        String s = objectMapper.writeValueAsString(subjectByProfessorId);
        log.info("Professor find all - Content:{}", s);
        return subjectByProfessorId;
    }

}
