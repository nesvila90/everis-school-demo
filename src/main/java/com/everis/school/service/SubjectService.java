package com.everis.school.service;

import com.everis.school.model.Student;
import com.everis.school.model.Subject;
import com.everis.school.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Page<Student> fetchSubjectWithStudents(Long id, Pageable pageable){
        return subjectRepository.fetchSubjectWithStudents(id,pageable);
    }

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }
}
