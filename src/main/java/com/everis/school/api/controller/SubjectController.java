package com.everis.school.api.controller;

import com.everis.school.model.Student;
import com.everis.school.model.Subject;
import com.everis.school.repository.SubjectRepository;
import com.everis.school.service.SubjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;
    private final ObjectMapper objectMapper;

    @Autowired
    public SubjectController(SubjectService subjectService, ObjectMapper objectMapper) {
        this.subjectService = subjectService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<Subject> findAll() throws JsonProcessingException {
        List<Subject> all = subjectService.findAll();
        String s = objectMapper.writeValueAsString(all);
        log.info("Professor find all - Content:{}", s);
        return all;
    }

    @GetMapping("/{id}/asignaturas/estudiantes")
    public Page<Student> getAsignaturasWithStudents(@PathVariable Long id, Pageable pageable) throws JsonProcessingException {
        Page<Student> students = subjectService.fetchSubjectWithStudents(id, pageable);
        String s = objectMapper.writeValueAsString(students);
        log.info("Professor find all - Content:{}", s);
        return students;
    }
}
