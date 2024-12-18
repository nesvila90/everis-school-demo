package com.everis.school.api.controller;

import com.everis.school.model.Professor;
import com.everis.school.model.Subject;
import com.everis.school.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {


    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> fetchAll(){
        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/{id}/subjects")
    public Page<Subject> getAsignaturasByProfesor(@PathVariable Long id, Pageable pageable) {
        return professorService.findSubjectByProfessorId(id, pageable);
    }

}
