package com.everis.school.repository;

import com.everis.school.model.Professor;
import com.everis.school.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT a from Professor p join p.subjects a WHERE p.id = :id")
    Page<Subject> findSubjectsByProfessorId(Long id, Pageable pageable);
}
