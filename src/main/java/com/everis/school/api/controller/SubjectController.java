package com.everis.school.api.controller;

import com.everis.school.model.Student;
import com.everis.school.model.Subject;
import com.everis.school.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> findAll() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}/asignaturas/estudiantes")
    public Page<Student> getAsignaturasWithStudents(@PathVariable Long id, Pageable pageable) {
        return subjectService.fetchSubjectWithStudents(id, pageable);
    }
}
