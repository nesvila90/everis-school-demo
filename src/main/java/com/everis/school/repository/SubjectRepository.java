package com.everis.school.repository;

import com.everis.school.model.Student;
import com.everis.school.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT st FROM Subject s JOIN s.students st WHERE s.id = :id")
    Page<Student> fetchSubjectWithStudents(@Param("id") Long id, Pageable pageable);
}
